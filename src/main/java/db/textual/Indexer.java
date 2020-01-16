package db.textual;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Indexer {
    private IndexWriter writer;

    public Indexer(String indexDirectoryPath) throws IOException {
        Analyzer analyzer = new StandardAnalyzer();

        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
        iwc.setOpenMode(OpenMode.CREATE_OR_APPEND);
        Directory indexDirectory = FSDirectory.open(Paths.get(indexDirectoryPath));

        writer = new IndexWriter(indexDirectory, iwc);
    }

    public void close() throws CorruptIndexException, IOException {
        writer.close();
    }

    private Document getDocument(Path file) throws IOException {
        Document document = new Document();
        document.add(new StringField("path", file.getFileName().toString().replace(".txt", ""), Field.Store.YES));
        document.add(new TextField("contents", new String(Files.readAllBytes(file)), Store.YES));
        document.add(new StringField("type", file.toFile().getParentFile().getName(), Field.Store.YES));
        return document;
    }

    private void indexFile(Path file) throws IOException {
        Document document = getDocument(file);
        writer.updateDocument(new Term("path", file.toString()), document);
    }

    public void createIndex(String dataDirPath) throws IOException {
        Path file = Paths.get(dataDirPath);
        if (Files.isDirectory(file)) {

            Files.walkFileTree(file, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    try {
                        //Index this file
                        indexFile(file);
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } else {
            indexFile(file);
        }
    }

    public IndexWriter getWriter() {
        return writer;
    }

    public void setWriter(IndexWriter writer) {
        this.writer = writer;
    }
}