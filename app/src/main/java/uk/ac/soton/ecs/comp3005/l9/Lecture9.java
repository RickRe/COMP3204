package uk.ac.soton.ecs.comp3005.l9;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openimaj.content.slideshow.PictureSlide;
import org.openimaj.content.slideshow.Slide;
import org.openimaj.content.slideshow.SlideshowApplication;
import org.openimaj.content.slideshow.VideoSlide;
import org.openimaj.video.VideoDisplay.EndAction;

import uk.ac.soton.ecs.comp3005.utils.Utils;
import uk.ac.soton.ecs.comp3005.utils.annotations.JvmArgs;
import uk.ac.soton.ecs.comp3005.utils.annotations.Lecture;

@Lecture(title = "L9: Image Search and Classification",
		handoutsURL = "http://jonhare.github.io/COMP3005/handouts/pdf/L9-imagesearchclass.pdf",
		slidesURL = "http://jonhare.github.io/COMP3005/lectures/pdf/L9-imagesearchclass.pdf")
@JvmArgs(vmArguments = "-Xmx1G")
public class Lecture9 {
	public static void main(String[] args) throws IOException {
		final List<Slide> slides = new ArrayList<Slide>();

		for (int i = 1; i <= 28; i++)
			slides.add(new PictureSlide(Lecture9.class.getResource(String.format("l9.%03d.jpg", i))));

		slides.add(new BoVWHistogramDemo());

		for (int i = 29; i <= 37; i++)
			slides.add(new PictureSlide(Lecture9.class.getResource(String.format("l9.%03d.jpg", i))));

		slides.add(new VideoSlide(Lecture9.class.getResource("TrentoDuomo.mov"), Utils.BACKGROUND_IMAGE_URL,
				EndAction.PAUSE_AT_END));

		for (int i = 38; i <= 45; i++)
			slides.add(new PictureSlide(Lecture9.class.getResource(String.format("l9.%03d.jpg", i))));

		new SlideshowApplication(slides, 1024, 768, Utils.BACKGROUND_IMAGE);
	}
}
