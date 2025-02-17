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

import javax.swing.BorderFactory;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.piccolo2d.PCanvas;
import org.piccolo2d.PFrame;
import org.piccolo2d.PLayer;
import org.piccolo2d.pswing.PSwing;
import org.piccolo2d.pswing.PSwingCanvas;


/**
 * Demonstrates the use of PSwing in a Piccolo application.
 */

public class PSwingExample extends PFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public PSwingExample() {
        this(new PSwingCanvas());
    }

    public PSwingExample(final PCanvas aCanvas) {
        super("PSwingExample", false, aCanvas);
    }

    public void initialize() {
        final PSwingCanvas pswingCanvas = (PSwingCanvas) getCanvas();
        final PLayer l = pswingCanvas.getLayer();

        final JSlider js = new JSlider(0, 100);
        js.addChangeListener(new ChangeListener() {
            public void stateChanged(final ChangeEvent e) {
                System.out.println("e = " + e);
            }
        });
        js.setBorder(BorderFactory.createTitledBorder("Test JSlider"));
        final PSwing pSwing = new PSwing(js);
        pSwing.translate(100, 100);
        l.addChild(pSwing);

        pswingCanvas.setPanEventHandler(null);
    }

    public static void main(final String[] args) {
        new PSwingExample();
    }
}
