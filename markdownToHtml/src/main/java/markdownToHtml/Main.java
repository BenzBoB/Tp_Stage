package markdownToHtml;

import java.io.IOException;
import java.net.URISyntaxException;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import com.google.googlejavaformat.java.FormatterException;

import markdownToHtml.utils.BuildHTML;

public class Main {

	public static void main(String[] args) throws FormatterException, IOException, URISyntaxException {

		final String millefeuille = BuildHTML.getFileContent("Patisseries\\Millefeuiles.md");
		final String tarteAuCitron = BuildHTML.getFileContent("Patisseries\\Tarte_au_citron.md");
		final String croissant = BuildHTML.getFileContent("Viennoiseries\\Croissants.md");
		final String painAuChocolat = BuildHTML.getFileContent("Viennoiseries\\Pain_au_chocolat.md");
		
		final Parser parser = Parser.builder().build();
		
		final Node document1 = parser.parse(millefeuille);
		final Node document2 = parser.parse(tarteAuCitron);
		final Node document3 = parser.parse(croissant);
		final Node document4 = parser.parse(painAuChocolat);
		
		final HtmlRenderer renderer = HtmlRenderer.builder().build();
		
		final String markdownHtml1 = renderer.render(document1);
		final String markdownHtml2 = renderer.render(document2);
		final String markdownHtml3 = renderer.render(document3);
		final String markdownHtml4 = renderer.render(document4);
		
		BuildHTML.WriteFileHtml(markdownHtml1, "Millefeuiles");
		BuildHTML.WriteFileHtml(markdownHtml2, "Tarte_au_citron");
		BuildHTML.WriteFileHtml(markdownHtml3, "Croissants");
		BuildHTML.WriteFileHtml(markdownHtml4, "Pain_au_chocolat");
		
	}

}
