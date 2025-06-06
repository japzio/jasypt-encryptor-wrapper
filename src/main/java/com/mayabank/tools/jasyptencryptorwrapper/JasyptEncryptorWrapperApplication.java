package com.mayabank.tools.jasyptencryptorwrapper;

import com.mayabank.tools.jasyptencryptorwrapper.properties.JasyptConfigProperties;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class JasyptEncryptorWrapperApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(JasyptEncryptorWrapperApplication.class);

	@Autowired
	private JasyptConfigProperties jasyptConfig;

	public static void main(String[] args) {
		SpringApplication.run(JasyptEncryptorWrapperApplication.class, args);
	}

	public void run(String... args) {
		logger.info("EXECUTING : command line runner");

		for(int i = 0; i < args.length; ++i) {
			logger.info("args[{}]: {}", i, args[i]);
		}

		logger.info("Starting {}", this.getClass().getSimpleName());

        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(jasyptConfig.getPassword());
        config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        String encryptedString = encryptor.encrypt(jasyptConfig.getRawString());
        logger.info("Encrypted string: {}", encryptedString);

	}
}
