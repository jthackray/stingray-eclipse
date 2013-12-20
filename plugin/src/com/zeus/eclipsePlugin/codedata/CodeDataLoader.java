/*******************************************************************************
 * Copyright (C) 2014 Riverbed Technology, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://github.com/riverbed/stingray-eclipse/blob/master/LICENSE
 * This software is distributed "AS IS".
 *
 * Contributors:
 *     Riverbed Technology - Main Implementation
 ******************************************************************************/

package com.zeus.eclipsePlugin.codedata;

/**
 * Class to load TrafficScript data. 
 */
public interface CodeDataLoader
{
   /**
    * Get the TrafficScript code data for the specified version. If this exact 
    * version is unavailable, return the closest version instead.
    * 
    * @param major The major version number
    * @param min The minor version number.
    * @return A TrafficScriptVersion storing code data, or null if nothing could
    * be found.
    */
   public VersionCodeData getTrafficScriptVersion( int major, int min );
}
