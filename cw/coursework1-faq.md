---
layout: index
rdir: "../"
title: "COMP3204 Computer Vision"
subtitle: "Coursework 1 FAQ & Problem Solving"
githubHeader: "false"
credits: Maintained by <a href="http://www.ecs.soton.ac.uk/people/msn">Professor Mark Nixon</a> and <a href="http://www.ecs.soton.ac.uk/people/jsh2">Dr Jonathon Hare</a>.
---

Let us know of any problems you encounter issues or have questions & we'll add them to the list below:

## I've found a bug in the tutorial!
Try looking in the development version here: http://openimaj.github.io/openimaj/tutorial and see if it has been fixed. If not, let us know via email or create a pull request on GitHub with a fix :)

## Problems loading images in Tutorial Chapter 4
Unfortunately the URLs to the images in the code no longer work. If you're following the 1.3.6 version of the tutorial they can be accessed at:

- http://openimaj.org/tutorial/figs/hist1.jpg
- http://openimaj.org/tutorial/figs/hist2.jpg
- http://openimaj.org/tutorial/figs/hist3.jpg

(This is fixed in version 1.3.7)

## Need to reset the (flickr/Bing) API token?
`DefaultTokenFactory.delete(FlickrAPIToken.class)` will remove any previously set API token. Next time you run `DefaultTokenFactory.get(FlickrAPIToken.class)` it will prompt you on the command line to enter the API key.

## Bing API token URL is wrong
MS has changed the URL (again!). You can get a free key valid for 7 days from here:  https://azure.microsoft.com/en-us/try/cognitive-services/my-apis/

(You'll only need the key to try that bit of the tutorial & you can skip that part if you like).

## Problems with Maven:

### Error building pom:
If you get a error message saying there was an error building the pom that looks like this:
	
	...
	...
	...
	[INFO] ------------------------------------------------------------------------
	[ERROR] BUILD ERROR
	[INFO] ------------------------------------------------------------------------
	[INFO] Error building POM (may not be this project's POM).


	Project ID: null:opennlp-tools:bundle:null

	Reason: Cannot find parent: org.apache.opennlp:opennlp for project: null:opennlp-tools:bundle:null for project null:opennlp-tools:bundle:null


	[INFO] ------------------------------------------------------------------------
	[INFO] For more information, run Maven with the -e switch
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 4 seconds
	[INFO] Finished at: Fri Oct 03 13:56:37 BST 2014
	[INFO] Final Memory: 39M/445M
	[INFO] ------------------------------------------------------------------------

Then edit the pom.xml file in a text editor and comment out the xml block for the `common-stream` dependency. Maven should then run without issue. We're actively looking into why this happens (it doesn't happen on all machines, but was observed on a Zepler lab linux box).

### Maven is slow! 
If you're trying to do development without an IDE Maven might be driving you insane with long build times; in particular, you're probably calling the `mvn assembly:assembly` command (or some variant with `package` included). The Maven assembly plugin does take a *long* while to run, but it's not something you should normally use until you want to package up a jar file with all the dependencies - more specifically you should not be using it for development!

Here are some hints that will help speed up your builds during development:

* `mvn compile` will just build the class files
* `mvn package` will compile the classes and create a jar that just contains your project's code - this should be very quick (I can build medium sized projects in less than 2 secs on my laptop)
* the `-o` command line flag puts maven in offline mode - that means it will not go away and look for new versions of snapshot dependencies and will just use the ones available locally (this will speed things up significantly if you have lots of dependencies)
* The Maven "exec" plugin can be used to run your code without packaging it, so for example if you were trying to do rapid development and test iterations you could do something like this: `mvn -o compile exec:java -Dexec.mainClass="uk.ac.soton.ecs.comp3204.MainMenu"`

### "mvn assembly:assembly" is really slow.
We think this might be to do with the networked file-system housing your home areas on the Zepler lab machines. On a local disk, it runs within a few 10's of seconds. Fortunately, you don't need to do this often as you can run the code directly from Eclipse (or your IDE of choice) and so hopefully won't be too much of a problem in the long-run.

## Out of heap space errors with the FelzenszwalbHuttenlocherSegmenter
It's a rather memory hungry algorithm, so either reduce the image size or give java more heap space.



 