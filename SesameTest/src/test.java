import org.openrdf.model.Literal;
import org.openrdf.model.URI;
import org.openrdf.model.ValueFactory;
import org.openrdf.model.impl.ValueFactoryImpl;
import org.openrdf.model.vocabulary.RDF;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.http.HTTPRepository;
import org.openrdf.repository.sail.SailRepository;
import org.openrdf.sail.memory.MemoryStore;




public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Here we go!!");
		
		
		//the connection to the remote RDF repo
		
		String sesameServer = "http://132.206.14.223:8080/openrdf-sesame/";
		String repositoryID = "jintest";

		Repository repo = new HTTPRepository(sesameServer, repositoryID);
		
		// initialize the ValueFactory and some testing data for insert test
		ValueFactory f = repo.getValueFactory();
		
	
		try {
			repo.initialize();
			RepositoryConnection con = repo.getConnection();
			
			URI alice = f.createURI("http://example.org/people/alice");
			URI bob = f.createURI("http://example.org/people/bob");
			URI name = f.createURI("http://example.org/ontology/name");
			URI person = f.createURI("http://example.org/ontology/Person");
			Literal bobsName = f.createLiteral("Bob");
			Literal alicesName = f.createLiteral("Alice");
			
			// try to add the data with the connection
			
			   try {
				      // alice is a person
				      con.add(alice, RDF.TYPE, person);
				      // alice's name is "Alice"
				      con.add(alice, name, alicesName);

				      // bob is a person
				      con.add(bob, RDF.TYPE, person);
				      // bob's name is "Bob"
				      con.add(bob, name, bobsName);
				   }
				   finally {
				      con.close();
				   }
			
			
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
