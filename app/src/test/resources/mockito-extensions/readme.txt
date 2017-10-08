Kotlin classes and functions are declared as final/closed by default

but

Mockito cannot mock/spy because :
– final class

To resolve the above issue:

Enable the option to mock final classes

To do this, you’ll need to create a file in the
test/resources/mockito-extensions folder called
org.mockito.plugins.MockMaker

It’s a simple text file, in which you have to write:
mock-maker-inline

https://antonioleiva.com/mockito-2-kotlin/

