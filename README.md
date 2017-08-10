## Synopsis
A Java program that parse any input text and extract every date it contains (See format section) and count the dates.

###### Date formats
* **yyyy-MM-dd** _(example: 2017-08-10)_
* **dd MMMM yyyy** _(example: 10 August 2017)_
* **MMMM dd, yyyy** _(example: August 10, 2017)_

The addition of other date formats is easy, just add the desired format and indicate the regular expression associated with it in the `DateUtil` class
## Input example
```
Marvin Lee Minsky at the Mathematics Genealogy Project; 20 May 2014

Marvin Lee Minsky at the AI Genealogy Project. {reprint 18 September 2011)

"Personal page for Marvin Minsky". web.media.mit.edu. Retrieved 23 June 2016.

Admin (January 27, 2016). "Official Alcor Statement Concerning Marvin Minsky". 

	Alcor Life Extension Foundation. Retrieved 2016-04-07.

"IEEE Computer Society Magazine Honors Artificial Intelligence Leaders". 

	DigitalJournal.com. August 24, 2011. Retrieved September 18, 2011. 

	Press release source: PRWeb (Vocus).

"Dan David prize 2014 winners". May 15, 2014. Retrieved May 20, 2014.
```
## Output example
```
2011:
           -08
                  -25 (1)
           -09
                  -19 (2)
2014:
           -05
                  -16 (1)
                  -21 (2)
2016:
           -01
                  -28 (1)
           -04
                  -08 (1)
           -06
                  -24 (1)
```
