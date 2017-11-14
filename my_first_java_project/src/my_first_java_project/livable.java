package my_first_java_project;

public interface livable 
{
//prior to Java 8, interfaces could not implement methods
	int reproduce(int partiesInvolved);
	void consume(String... substance);
	int perish(double timeToLive);
	String waste();
	String move();
}
