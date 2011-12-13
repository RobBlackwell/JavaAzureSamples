import com.microsoft.windowsazure.services.core.storage.*; 
import com.microsoft.windowsazure.services.blob.client.*; 

public class ListBlobs
{
    public static void main(String[] args) throws Exception {

	if (args.length != 1) {
	    System.err.println("Usage: ListBlobs <container>");
	    System.exit(1);
	}

	String storageConnectionString = System.getenv("AZURE_CONNECTION_STRING");
            
	if (storageConnectionString == null) {
	    System.err.println("AZURE_CONNECTION_STRING not set");
	    System.exit(1);
	}

	String containerName = args[0];

	CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);

	CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
	
	CloudBlobContainer container = blobClient.getContainerReference(containerName);

	for (ListBlobItem blobItem : container.listBlobs()) {
	    System.out.println(blobItem.getUri());
	}

    }  
}