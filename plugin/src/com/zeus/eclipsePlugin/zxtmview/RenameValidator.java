/*******************************************************************************
 * Copyright (C) 2013 Riverbed Technology, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Riverbed Technology - Main Implementation
 ******************************************************************************/

package com.zeus.eclipsePlugin.zxtmview;

import org.eclipse.jface.dialogs.IInputValidator;

import com.zeus.eclipsePlugin.ZLang;
import com.zeus.eclipsePlugin.ZUtil;
import com.zeus.eclipsePlugin.model.ZXTM;

/**
 * Input validator for rule names.
 */
public class RenameValidator implements IInputValidator
{
   private ZXTM zxtm;
   
   /**
    * Setup the validator with the destination for the rule.
    * @param zxtm The ZXTM this rule will be put in. Used to check for 2 rules
    * with the same name.
    */
   public RenameValidator( ZXTM zxtm )
   {
      this.zxtm = zxtm;
   }

   /**
    * Checks the rule name is valid and not already in use.
    */
   /* Override */
   public String isValid( String name )
   {
      name = name.trim();
      
      String nameError = ZUtil.validateRuleName( name );
      if( nameError != null ) {
         return nameError;
      }
      
      if( zxtm.getRule( name ) != null ) {
         return ZLang.ZL_ValidationRuleAllreadyExists;
      }
    
      return null;
   }
   
}