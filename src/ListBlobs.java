import java.net.URI;
import java.io.File;
import java.util.Iterator;
import org.soyatec.windowsazure.blob.*; 
import org.soyatec.windowsazure.internal.util.TimeSpan;

public class ListBlobs
{
    public static void main(String[] args) throws Exception {

	if (args.length != 1) {
	    System.err.println("Usage: ListBlobs <container>");
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

	BlobStorageClient storage = BlobStorageClient
        .create(
            URI.create("http://blob.core.windows.net"),
            false,
            accountName ,
            accountKey);

	IBlobContainer container = storage.getBlobContainer(containerName);

	Iterator blobs  = container.listBlobs();

	while(blobs.hasNext()) {
	    Object element = blobs.next(); 
	    System.out.println(((IBlobProperties)element).getName());
	} 
    }  
}