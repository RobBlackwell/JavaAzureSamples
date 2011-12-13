JavaAzureSamples
================

Working with the Windows Azure SDK for Java can be a bit of a fiddle,
especially from a command line on a Unix box. This project aims to
give you a quick way to get up an running.

Assumes that Java JDK >= 1.6 is installed and available on your path.

Change into the bin directory, and run the build-all script.

% source build-all

Edit the setup.sh and fill in your account details (You can get these
from the Windows Azure Management portal). This sets up
AZURE_CONNECTION_STRING as an environment variables.

% source setup.sh

Now you can try the samples

% source ListBlobs.sh mycontainer

For more info see http://msdn.microsoft.com/en-us/library/windowsazure/hh690953(v=VS.103).aspx

Rob Blackwell

December 2011

