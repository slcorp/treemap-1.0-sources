/**
 * Copyright (C) 2001 by University of Maryland, College Park, MD 20742, USA 
 * and Martin Wattenberg, w@bewitched.com
 * All rights reserved.
 * Authors: Benjamin B. Bederson and Martin Wattenberg
 * http://www.cs.umd.edu/hcil/treemaps
 */

package edu.umd.cs.treemap.test;

import edu.umd.cs.treemap.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A simple windowed application for testing map layouts.
 */
public class TreemapTest extends Frame {
    MapModel map;
    MapLayout algorithm;

    public TreemapTest() {
	int w = 400;
	int h = 400;

	map = new RandomMap(20);
	Mappable[] items = map.getItems();
	    
	algorithm = new StripTreemap();
	algorithm.layout(map, new Rect(0, 0, w, h));

	setBounds(100, 100, w, h);
	setVisible(true);

			// Watch for the user closing the window so we can exit gracefully
	addWindowListener (new WindowAdapter () {
		public void windowClosing (WindowEvent e) {
		    System.exit(0);
		}
	    });
    }

    public void paint(Graphics g) {
	Mappable[] items = map.getItems();
	Rect rect;

	g.setColor(Color.black);

	for (int i=0; i<items.length; i++) {
	    rect = items[i].getBounds();
	    int a=(int)rect.x;
	    int b=(int)rect.y;
	    int c=(int)(rect.x+rect.w)-a;
	    int d=(int)(rect.y+rect.h)-b;
	    g.drawRect(a,b,c,d);
	}
    }

    static public void main(String[] args) {
	new TreemapTest();
    }
}
