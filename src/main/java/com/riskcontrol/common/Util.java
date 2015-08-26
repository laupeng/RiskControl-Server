package com.riskcontrol.common;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Set;

/**
 * Created by Killua on 5/20/15.
 */
public class Util {

    private final static Logger logger = LoggerFactory.getLogger(Util.class);


    public static Set<Class<?>> findClassesInPackage(String scannedPackage) {
        return new Reflections(scannedPackage, new SubTypesScanner(false)).getSubTypesOf(Object.class);
    }

    public static String generateHashedPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(password.getBytes()); // Add password bytes to digest
            byte[] bytes = md.digest();     // Get the hash's bytes

//			This bytes[] has bytes in decimal format. Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error(sw.toString());
        }

        return password;
    }
}
