/*
 * jSite-remote - UpdateChecker.java -
 * Copyright © 2008 David Roden
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */

package de.todesbaum.jsite.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import de.todesbaum.jsite.application.Freenet7Interface;
import de.todesbaum.jsite.i18n.I18n;
import de.todesbaum.jsite.i18n.I18nContainer;

/**
 * Checks for newer versions of jSite.
 *
 * @author David ‘Bombe’ Roden &lt;bombe@freenetproject.org&gt;
 */
public class UpdateChecker {

	/** The URL for update checks. */
	@SuppressWarnings("unused")
	private static final String UPDATE_KEY = "USK@e3myoFyp5avg6WYN16ImHri6J7Nj8980Fm~aQe4EX1U,QvbWT0ImE0TwLODTl7EoJx2NBnwDxTbLTE6zkB-eGPs,AQACAAE/jSite/0/currentVersion.txt";

	/** The parent of the dialog. */
	@SuppressWarnings("unused")
	private final JFrame parent;

	/** The freenet interface. */
	@SuppressWarnings("unused")
	private final Freenet7Interface freenetInterface;

	/** The cancel action. */
	@SuppressWarnings("unused")
	private Action cancelAction;

	/**
	 * Creates a new update checker that uses the given frame as its parent and
	 * communications via the given freenet interface.
	 *
	 * @param parent
	 *            The parent of the dialog
	 * @param freenetInterface
	 *            The freenet interface
	 */
	public UpdateChecker(JFrame parent, Freenet7Interface freenetInterface) {
		this.parent = parent;
		this.freenetInterface = freenetInterface;
		initActions();
	}

	//
	// ACTIONS
	//

	/**
	 * Checks for updates, showing a dialog with an indeterminate progress bar.
	 */
	public void checkForUpdates() {
		showBusyDialog();
	}

	//
	// PRIVATE METHODS
	//

	/**
	 * Initializes all actions.
	 */
	private void initActions() {
		cancelAction = new AbstractAction(I18n.getMessage("")) {

			/**
			 * {@inheritDoc}
			 */
			public void actionPerformed(ActionEvent actionEvent) {
				/* TODO */
			}
		};
	}

	/**
	 * Shows a “please wait” dialog.
	 */
	private void showBusyDialog() {
		new Thread(new Runnable() {

			@SuppressWarnings("synthetic-access")
			public void run() {
				BusyPanel busyPanel = new BusyPanel();
				JButton cancelButton = new JButton(cancelAction);
				JOptionPane.showOptionDialog(parent, busyPanel, I18n.getMessage(""), 0, JOptionPane.INFORMATION_MESSAGE, null, new Object[] { cancelButton }, cancelButton);
			}
		}).start();
	}

	/**
	 * A panel that shows a busy progress bar and a “please wait” message.
	 *
	 * @author David ‘Bombe’ Roden &lt;bombe@freenetproject.org&gt;
	 */
	private class BusyPanel extends JPanel {

		/**
		 * Creates a new busy panel.
		 */
		public BusyPanel() {
			super(new BorderLayout(12, 12));
			initComponents();
		}

		//
		// PRIVATE METHODS
		//

		/**
		 * Initializes all components of this panel.
		 */
		private void initComponents() {
			final JLabel label = new JLabel(I18n.getMessage("")); /* TODO */
			JProgressBar progressBar = new JProgressBar();
			progressBar.setIndeterminate(true);

			add(label, BorderLayout.PAGE_START);
			add(progressBar, BorderLayout.PAGE_END);

			I18nContainer.getInstance().registerRunnable(new Runnable() {

				/**
				 * {@inheritDoc}
				 */
				public void run() {
					label.setText(I18n.getMessage("")); /* TODO */
				}
			});
		}

	}

}
