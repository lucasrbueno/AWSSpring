package br.edu.infnet.AWSpring;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.io.File;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AwSpringApplication {
    
    String arquivo = "C:\\Users\\lucas\\Documents\\NetBeansProjects\\a";

	public static void main(String[] args) {
		SpringApplication.run(AwSpringApplication.class, args);
	}

        @Bean
        ApplicationRunner applicationRunner(AmazonS3 amazons3){
            return args -> {
//                amazons3.listBuckets().forEach(bucket -> System.out.println(bucket.getName())); 
            upload();
            };
        }
        
        public static void upload(){
            Regions regiao = Regions.SA_EAST_1;
            String bucket = "demo-infnet1";
            String nomeDoTxt = "teste123";
            String fileObjKeyName = "*** File object key name ***";
            String fileName = "*** Path to file to upload ***";

            try {
                AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                        .withRegion(regiao)
                        .build();

                s3Client.putObject(bucket, nomeDoTxt, "Sou um teste AWS");

//                PutObjectRequest request = new PutObjectRequest(bucketName, fileObjKeyName, new File(fileName));
//                ObjectMetadata metadata = new ObjectMetadata();
//                metadata.setContentType("plain/text");
//                metadata.addUserMetadata("title", "someTitle");
//                request.setMetadata(metadata);
//                s3Client.putObject(request);
            } catch (AmazonServiceException e) {
            } catch (SdkClientException e) {
            }
        }
}
