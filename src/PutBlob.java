
import java.io.*;
import com.microsoft.windowsazure.services.core.storage.*; 
import com.microsoft.windowsazure.services.blob.client.*; 

public class PutBlob
{
    public static void main(String[] args) throws Exception {

	if (args.length != 2) {
	    System.err.println("Usage: PutBlob <container> <file>");
	    System.exit(1);
	}

	String storageConnectionString = System.getenv("AZURE_CONNECTION_STRING");
            
	if (storageConnectionString == null) {
	    System.err.println("AZURE_CONNECTION_STRING not set");
	    System.exit(1);
	}

	String containerName = args[0];
	String fileName = args[1];

	CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);

	CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
	
	CloudBlobContainer container = blobClient.getContainerReference(containerName);
	container.createIfNotExist();

	CloudBlockBlob blob = container.getBlockBlobReference(fileName);
	File source = new File(fileName);
	blob.upload(new FileInputStream(source), source.length());


    }  
}