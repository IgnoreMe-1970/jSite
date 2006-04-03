/*
 * jSite - a tool for uploading websites into Freenet
 * Copyright (C) 2006 David Roden
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

package de.todesbaum.jsite.application;

import java.util.EventListener;

/**
 * @author David Roden &lt;droden@gmail.com&gt;
 * @version $Id: InsertListener.java 397 2006-03-25 16:11:34Z bombe $
 */
public interface InsertListener extends EventListener {

	public static enum ErrorType {
		KEY_COLLISION, ROUTE_NOT_FOUND, DATA_NOT_FOUND, FCP_ERROR, IO_ERROR
	}

	public void projectInsertStarted(Project project);

	public void projectInsertProgress(Project project, int succeeded, int failed, int fatal, int total, boolean finalized);

	public void projectInsertFinished(Project project, boolean success, Throwable cause);

}
