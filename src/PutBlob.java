import java.net.URI;
import java.io.File;
import org.soyatec.windowsazure.blob.*; 
import org.soyatec.windowsazure.internal.util.TimeSpan;

public class PutBlob
{
    public static void main(String[] args) throws Exception {

	if (args.length != 2) {
	    System.err.println("Usage: PutBlob <container> <file>");
	    System.exit(1);
	}

	String accountName = System.getenv("AZURE_ACCOUNT_NAME");
            
	if (accountName == null) {
	    System.err.println("AZURE_ACCOUNT_NAME not set");
	    System.exit(1);
	}

	String accountKey = System.getenv("AZURE_ACCOUNT_KEY");
            
	if (accountKey == null) {
	    System.exit(1);
	    System.err.println("AZURE_ACCOUNT_KEY not set");
	}

	String containerName = args[0];
	String blobName = args[1];

	BlobStorageClient storage = BlobStorageClient
        .create(
            URI.create("http://blob.core.windows.net"),
            false,
            accountName ,
            accountKey);

	IBlobContainer container = storage.getBlobContainer(containerName);

	IBlobProperties blobProperties = storage.createBlobProperties(blobName);
	blobProperties.setContentType("binary/octet-stream");

	IBlobContents blobContents = storage.createBlobContents(new File(blobName));

	IBlockBlob blockBlob = container.createBlockBlob(blobProperties, blobContents);
    }  
}