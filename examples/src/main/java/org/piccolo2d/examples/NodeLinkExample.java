/*
 * Copyright (c) 2008-2019, Piccolo2D project, http://piccolo2d.org
 * Copyright (c) 1998-2008, University of Maryland
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided
 * that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions
 * and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 * and the following disclaimer in the documentation and/or other materials provided with the
 * distribution.
 *
 * None of the name of the University of Maryland, the name of the Piccolo2D project, or the names of its
 * contributors may be used to endorse or promote products derived from this software without specific
 * prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
 * TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.piccolo2d.examples;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.piccolo2d.PCanvas;
import org.piccolo2d.PFrame;
import org.piccolo2d.PNode;
import org.piccolo2d.event.PDragEventHandler;
import org.piccolo2d.nodes.PPath;


/**
 * Simple example showing one way to create a link between two nodes.
 * 
 * @author Jesse Grosjean
 */
public class NodeLinkExample extends PFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    PNode node1;
    PNode node2;
    PPath link;

    public NodeLinkExample() {
        this(null);
    }

    public NodeLinkExample(final PCanvas aCanvas) {
        super("NodeLinkExample", false, aCanvas);
    }

    public void initialize() {
        final PCanvas canvas = getCanvas();

        canvas.removeInputEventListener(canvas.getPanEventHandler());
        canvas.addInputEventListener(new PDragEventHandler());

        final PNode layer = canvas.getLayer();

        node1 = PPath.createEllipse(0, 0, 100, 100);
        node2 = PPath.createEllipse(0, 0, 100, 100);
        link = PPath.createLine(50, 50, 50, 50);
        link.setPickable(false);
        layer.addChild(node1);
        layer.addChild(node2);
        layer.addChild(link);

        node2.translate(200, 200);

        node1.addPropertyChangeListener(PNode.PROPERTY_FULL_BOUNDS, new PropertyChangeListener() {
            public void propertyChange(final PropertyChangeEvent arg0) {
                updateLink();
            }
        });

        node2.addPropertyChangeListener(PNode.PROPERTY_FULL_BOUNDS, new PropertyChangeListener() {
            public void propertyChange(final PropertyChangeEvent arg0) {
                updateLink();
            }
        });
    }

    public void updateLink() {
        final Point2D p1 = node1.getFullBoundsReference().getCenter2D();
        final Point2D p2 = node2.getFullBoundsReference().getCenter2D();
        final Line2D line = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        link.reset();
        link.append(line, false);
        link.closePath();
    }

    public static void main(final String[] args) {
        new NodeLinkExample();
    }
}
