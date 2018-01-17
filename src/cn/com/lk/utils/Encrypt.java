package cn.com.lk.utils;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;

import cn.com.lk.constant.RealmConstant;

public class Encrypt {
	
	public static String Md5Hash(String password){
		
		return new Md5Hash(password, RealmConstant.MD5_HASH_SALT, RealmConstant.MD5_HASH_ITERATION).toString();
	}
	
	public static String SHA256(String password){
		
		return new Sha256Hash(password, RealmConstant.SHA256_HASH_SALT, RealmConstant.SHA256_HASH_ITERATION).toString();
	}
}
