# helloworld

## Greenqloud setup

1. Clone this repo; `git clone https://github.com/arnihermann/helloworld`
2. Run Greenqloud Xvfb setup script; `cd helloworld; bin/greenqloud_xvfb_setup`

## Selenium

Some helpful links:

* [Read the docs!]([Download the zip file](http://chromedriver.storage.googleapis.com/index.html)
* [Selenium IDE](http://www.seleniumhq.org/projects/ide/)

### Selenium tests

1. FirefoxTestTitleIT - that runs a Selenium native WebDriver that controls Firefox
2. ~~ChromeTestTitleIT - that sets up and runs using Google Chrome (via [chromedriver](http://code.google.com/p/selenium/wiki/ChromeDriver))~~


#### Run the tests on the Greenqloud server

Greenqloud is a server, and has no display to run GUI programs like a browser. We would still like to run Selenium tests on servers, and [Xvfb](http://en.wikipedia.org/wiki/Xvfb) allows us to do just that.

To setup the requirements on the Greenqloud server, we've embedded a script in the repo. Just run:

    bin/greenqloud_xvfb_setup

This script installs Firefox browser, Xvfb and dependencies.

Now you have everything setup, simply run:

    bin/package
    bin/selenium_test_xvfb

#### For running locally

Firefox is required, we reccomend version 24.

When running locally we won't need Xvfb (in most cases), while developing, and we also like to be able to start and stop the server ourselves. So first:

    bin/package
    bin/run

And in another terminal (command line) window run the tests:

    bin/selenium_test
