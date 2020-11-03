package sk.stuba.fei.uim.asos.xsd_import;

import sk.stuba.fei.uim.asos.books.ws.*;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

import static sk.stuba.fei.uim.asos.books.ws.BookType.KNIHA;

@WebService(name = "BookServicePortType", targetNamespace = "publisher")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class
})
public class BookEndpoint implements BookServicePortType {

    public Books list() {
        Books books = new Books();
        Book book = new Book();
        book.setName("The Lord of the Rings: The Fellowship of the Ring");
        book.setIsbn("978-000-748-830-8");
        book.setType(KNIHA);
        book.setPrice(10f);
        Author author = new Author();
        author.setName("John");
        author.setMiddleName("Ronald Reuel");
        author.setSurname("Tolkien");
        book.getAuthors().add(author);
        books.getBook().add(book);
        return books;
    }
}
