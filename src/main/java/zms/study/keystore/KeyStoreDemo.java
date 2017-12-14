package zms.study.keystore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.junit.Test;
  
  
/** 
 * 把生成的密钥key保存到文件 和  读取文件中保存的密钥key 
 * (发送方进行加密，接收方进行解密) 
 * @author win7 
 * 
 */  
public class KeyStoreDemo {  
    //要加密的数据  
    public static String bobo="http://blog.csdn.net/bobo0915";  
    //加密后的密文数据  
    public static byte[] result;  //需要传输给 接收方 接收方进行解密  
    public static void main(String[] args) {  
        sendSecret();  
        receiveSecret();  
    }  
  
    /** 
     * 模拟发送方 生成秘钥，并保存秘钥  
     * (通过其他方式把秘钥提供给接收方，邮件，网络，U盘...) 
     */  
    public static void sendSecret(){  
        try {  
        //1.初始化key秘钥      
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");  
            keyGenerator.init(new SecureRandom());  
            SecretKey secretKey= keyGenerator.generateKey();  
            //转换key秘钥  
            DESedeKeySpec deSedeKeySpec=new DESedeKeySpec(secretKey.getEncoded());  
            SecretKeyFactory secretKeyFactory=SecretKeyFactory.getInstance("DESede");  
            Key  key= secretKeyFactory.generateSecret(deSedeKeySpec);  
        //2.对生成的密钥key进行编码保存  
            //String keyencode= binary.encode(key.getEncoded());
            String keyencode="";
            for (byte b : key.getEncoded()) {
				int val=b&0xff;
				keyencode+=Integer.toHexString(val);
			}
            //写入文件保存  
            File file=new File("F:\\keyencode.txt");  
            OutputStream outputStream=new FileOutputStream(file);  
            outputStream.write(keyencode.getBytes());  
            outputStream.close();  
            System.out.println(keyencode+" -----> key保存成功");  
              
        //3.进行加密  
            Cipher cipher=Cipher.getInstance("DESede/ECB/PKCS5Padding");  
            cipher.init(Cipher.ENCRYPT_MODE, key);  
            result= cipher.doFinal(bobo.getBytes());
            String str="";
            for (byte b : result) {
				str+=Integer.toHexString(b&0xff);
			}
            System.out.println("发送方进行加密："+str);  
        } catch (Exception e) {  
            // TODO: handle exception  
            e.printStackTrace();  
        }  
    }  
      
    /** 
     * 模拟接收方 读取文件中的秘钥，进行加解密 
     */  
    public static void receiveSecret(){  
        try {  
            //1.读取文件中的密钥  
            File file = new File("F:\\keyencode.txt");  
            InputStream inputStream = new FileInputStream(file);//文件内容的字节流  
            InputStreamReader inputStreamReader= new InputStreamReader(inputStream); //得到文件的字符流  
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader); //放入读取缓冲区  
            String readd="";  
            StringBuffer stringBuffer=new StringBuffer();  
            while ((readd=bufferedReader.readLine())!=null) {  
                stringBuffer.append(readd);  
            }  
            inputStream.close();  
            String keystr=stringBuffer.toString();  
            System.out.println(keystr+" -----> key读取成功");  //读取出来的key是编码之后的 要进行转码  
              
         //2.通过读取到的key  获取到key秘钥对象  
           // byte[] keybyte= HexBin.decode(keystr);
            int bit=0;
            char[] chars=new char[keystr.getBytes().length];
            StringBuffer sb=new StringBuffer();
            byte[] bs=keystr.getBytes();
            for (byte b : bs) {
            	  bit = (b & 0x0f0) >> 4;      
                  sb.append(chars[bit]);      
                  bit = b & 0x0f;      
                  sb.append(chars[bit]);    
			}
            
            DESedeKeySpec deSedeKeySpec=new DESedeKeySpec(hexStringToByteArray(sb.toString()));  
            SecretKeyFactory secretKeyFactory=SecretKeyFactory.getInstance("DESede");  
            Key  key= secretKeyFactory.generateSecret(deSedeKeySpec); //获取到key秘钥  
              
        //3.进行解密  
            Cipher cipher=Cipher.getInstance("DESede/ECB/PKCS5Padding");  
            cipher.init(Cipher.DECRYPT_MODE, key);  
            result= cipher.doFinal(result);  
            System.out.println("接收方进行解密："+new String(result));  
        } catch (Exception e) {  
            // TODO: handle exception  
            e.printStackTrace();  
        }  
    } 
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] b = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            // 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个字节
            b[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character
                    .digit(s.charAt(i + 1), 16));
        }
        return b;
    }
    @Test
    public void test1(){
    	String hex="fabd";
    	char[] chars=hex.toCharArray();
    	for (int i=0;i<chars.length-1;) {
    		//按0-9-a-z,当字符大于radix为-1
    		int val=Character.digit(i, 16);
    		System.out.println((byte)((val<<4)+Character.digit(chars[i+1], 16)));
    		i+=2;
		}
    }
}
