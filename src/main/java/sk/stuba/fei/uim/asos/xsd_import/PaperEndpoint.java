package sk.stuba.fei.uim.asos.xsd_import;

import sk.stuba.fei.uim.asos.books.ws.*;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(name = "PaperServicePortType", targetNamespace = "publisher")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class
})
public class PaperEndpoint implements PaperServicePortType {

    public Papers list() {
        Papers papers = new Papers();
        Paper paper = new Paper();
        paper.setName("COMPUTING MACHINERY AND INTELLIGENCE");
        paper.setDoi("10.1093/mind/LIX.236.433");
        Author author = new Author();
        author.setName("Alan");
        author.setMiddleName("Mathison");
        author.setSurname("Turing");
        paper.getAuthors().add(author);
        papers.getPaper().add(paper);
        return papers;
    }
}
