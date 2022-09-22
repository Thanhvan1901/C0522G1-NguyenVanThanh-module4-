package codegym.service;

import codegym.model.Book;
import codegym.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{

    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return iBookRepository.findAll(pageable);
    }

    @Override
    public Book findById(int id) {
        return iBookRepository.findById(id).get();
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }



}
