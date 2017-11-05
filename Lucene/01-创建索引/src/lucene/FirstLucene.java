package lucene;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;

import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

/**
 * 创建索引
 * 查询索引
 * @author LGX
 *
 */
public class FirstLucene {

	//创建索引
	@Test
	public void testIndex() throws Exception {
		// 第一步：创建一个java工程，并导入jar包。
		
		// 第二步：创建一个indexwriter对象。
		//	1）指定索引库的存放位置Directory对象
		// 	2）指定一个分析器，对文档内容进行分析。
		Directory directory = FSDirectory.open(new File("D:\\lucene\\index"));
		Analyzer analyzer = new StandardAnalyzer();
		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_10_3, analyzer);
		IndexWriter indexWriter = new IndexWriter(directory, config);
		
		// 第三步：创建field对象，将field添加到document对象中。
		File filesDir = new File("D:\\lucene\\data");
		File[] files = filesDir.listFiles();
		for (File file : files) {
			Document document = new Document();
			// 文件名称
			String file_name = file.getName();
			Field fileNameField = new TextField("fileName", file_name, Store.YES);
			// 文件大小
			long file_size = FileUtils.sizeOf(file);
			Field fileSizeField = new LongField("fileSize", file_size, Store.YES);
			// 文件路径
			String file_path = file.getPath();
			Field filePathField = new StoredField("filePath", file_path);
			// 文件内容
			String file_content = FileUtils.readFileToString(file);
			Field fileContentField = new TextField("fileContent", file_content, Store.NO);
			document.add(fileNameField);
			document.add(fileSizeField);
			document.add(filePathField);
			document.add(fileContentField);
			
			// 第四步：使用indexwriter对象将document对象写入索引库，此过程进行索引创建。并将索引和document对象写入索引库。
			indexWriter.addDocument(document);
		}
		
		// 第五步：关闭IndexWriter对象。
		indexWriter.close();
	}
	
}
