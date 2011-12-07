JavaAzureSamples
================

Working with the [Windows Azure SDK for
Java](http://www.windowsazure4j.org/) can be a bit of a fiddle,
especially from a command line on a Unix box. People often report that
it's hard to navigate the web site and get started.  Several of the
online code samples are out of date.

I don't say that this is the best code in the world!, but I hope that
this project will give you some cut n paste code and a simple way to
get started.

Assumes that Java JDK >= 1.6 is installed and available on your path.

Change into the bin directory, and run the build-all script.

% source build-all

Edit the setup.sh and fill in your account details (You can get these
from the Windows Azure Management portal). This sets up
AZURE_ACCOUNT_NAME and AZURE_ACCOUNT_KEY as environment vaiables.

% source setup.sh

Now you can try the samples

% source ListBlobs.sh mycontainer

Rob Blackwell

December 2011

