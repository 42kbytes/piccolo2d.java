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
package org.piccolo2d.pswing;

import java.util.Vector;

import javax.swing.DefaultComboBoxModel;

import org.piccolo2d.pswing.PComboBox;
import org.piccolo2d.pswing.PSwing;
import org.piccolo2d.pswing.PSwingCanvas;

import junit.framework.TestCase;

/**
 * Unit test for PComboBox.
 */
public class PComboBoxTest extends TestCase {
    public void testPComboInstallsItsOwnUI() {
        final PComboBox combo = new PComboBox();
        assertTrue(combo.getUI() instanceof PComboBox.PBasicComboBoxUI);
    }

    public void testConstructsWithVector() {
        final Vector<String> items = new Vector<String>();
        items.add("A");
        items.add("B");
        final PComboBox combo = new PComboBox(items);
        assertEquals(2, combo.getModel().getSize());
    }

    public void testConstructsWithArray() {
        final String[] items = new String[] { "A", "B" };
        final PComboBox combo = new PComboBox(items);
        assertEquals(2, combo.getModel().getSize());
    }

    public void testConstructsWithComboBoxModel() {
        final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
        model.addElement("A");
        model.addElement("B");
        final PComboBox combo = new PComboBox(model);
        assertEquals(2, combo.getModel().getSize());
    }

    public void testSetEnvironmentPersists() {
        final PComboBox combo = new PComboBox();

        final PSwingCanvas canvas = new PSwingCanvas();
        final PSwing pCombo = new PSwing(combo);
        combo.setEnvironment(pCombo, canvas);

        assertEquals(pCombo, combo.getPSwing());
        assertEquals(canvas, combo.getCanvas());
    }

    public void testPopupIsRepositioned() {
        // Need a way of dispatching mock events to canvas before this can be
        // tested
    }
}
