package lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.NumericRangeQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**
 * 索引维护：增删改查
 * @author LGX
 *
 */
public class LuceneManager {

	//提取出getIndexWriter
	public IndexWriter getIndexWriter() throws Exception {
		Directory directory = FSDirectory.open(new File("D:\\lucene\\index"));
		Analyzer analyzer = new StandardAnalyzer();
		IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, analyzer);
		return new IndexWriter(directory, config);
	}
	
	//全删除
	@Test
	public void testAllDelete() throws Exception {
		IndexWriter indexWriter = getIndexWriter();
		indexWriter.deleteAll();
		indexWriter.close();
	}
	
	//根据条件删除
	@Test
	public void testDelete() throws Exception {
		IndexWriter indexWriter = getIndexWriter();
		Query query = new TermQuery(new Term("fileName", "readme"));
		indexWriter.deleteDocuments(query);
		indexWriter.close();
	}
	
	//修改(其实内部是先删后加)
	@Test
	public void testUpdate() throws Exception {
		IndexWriter indexWriter = getIndexWriter();
		Document document = new Document();
		document.add(new TextField("fileN", "测试文件名", Store.YES));
		document.add(new TextField("fileC", "测试文件内容", Store.YES));
		indexWriter.updateDocument(new Term("fileName", "readme"), document , new IKAnalyzer());
		indexWriter.close();
	}
	
	
	
	
	//提取出getIndexSearch
	public IndexSearcher getIndexSearcher() throws Exception {
		Directory directory = FSDirectory.open(new File("D:\\lucene\\index"));
		IndexReader indexReader = DirectoryReader.open(directory);
		return new IndexSearcher(indexReader);
	}
	
	//提取出打印方法
	public void printResult(IndexSearcher indexSearcher, Query query) throws Exception {
		TopDocs topDocs = indexSearcher.search(query, 10);
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		for (ScoreDoc scoreDoc : scoreDocs) {
			int docID = scoreDoc.doc;
			Document document = indexSearcher.doc(docID);
			String fileName = document.get("fileName");
			String fileSize = document.get("fileSize");
			String filePath = document.get("filePath");
			String fileContent = document.get("fileContent");
			System.out.println("============");
			System.out.println(fileName);
			System.out.println(fileSize);
			System.out.println(filePath);
			//System.out.println(fileContent);
			System.out.println("============\n");
		}
	}
		
	//查询所有
	@Test
	public void testMatchAllDocsQuery() throws Exception {
		IndexSearcher indexSearcher = getIndexSearcher();
		Query query = new MatchAllDocsQuery();
		printResult(indexSearcher, query);
		indexSearcher.getIndexReader().close();
	}
	
	//精准查询
	@Test
	public void testTermQuery() throws Exception {
		IndexSearcher indexSearcher = getIndexSearcher();
		Query query = new TermQuery(new Term("fileContent", "python"));
		printResult(indexSearcher, query);
		indexSearcher.getIndexReader().close();
	}
	
	//数值范围查询
	@Test
	public void testNumericRangeQuery() throws Exception {
		IndexSearcher indexSearcher = getIndexSearcher();
		Query query = NumericRangeQuery.newLongRange("fileSize", 6000L, 10000L, false, true);
		printResult(indexSearcher, query);
		indexSearcher.getIndexReader().close();
	}
	
	//组合查询
	@Test
	public void testBooleanQuery() throws Exception {
		IndexSearcher indexSearcher = getIndexSearcher();
		BooleanQuery booleanQuery = new BooleanQuery();
		Query query1 = new TermQuery(new Term("fileName", "version"));
		Query query2 = new TermQuery(new Term("fileName", "jre"));
		booleanQuery.add(query1, Occur.MUST);
		booleanQuery.add(query2, Occur.MUST);
		printResult(indexSearcher, booleanQuery);
		indexSearcher.getIndexReader().close();
	}
	

	
	
	//条件解析对象查询
	@Test
	public void testQueryParser() throws Exception {
		IndexSearcher indexSearcher = getIndexSearcher();
		QueryParser queryParser = new QueryParser("fileName", new IKAnalyzer());
		//查询所有
		// Query query = queryParser.parse("*:*");
		//精准查询
		// Query query = queryParser.parse("fileContent:java is apache");
		//范围查询(不支持字符串转Long)
		// Query query = queryParser.parse("fileSize:{0,1000]");
		//组合查询('+'为MUST ' '为SHOULD '-'为不必须)
		 Query query = queryParser.parse("+fileName:jre fileName:version");
		printResult(indexSearcher, query);
		indexSearcher.getIndexReader().close();
	}
	
	
	//条件解析对象查询(多个域)
	@Test
	public void testMultiFieldQueryParser() throws Exception {
		IndexSearcher indexSearcher = getIndexSearcher();
		String[] fields = {"fileName", "fileContent"};
		MultiFieldQueryParser queryParser = new MultiFieldQueryParser(fields, new IKAnalyzer());
		Query query = queryParser.parse("java");
		printResult(indexSearcher, query);
		indexSearcher.getIndexReader().close();
	}
}
