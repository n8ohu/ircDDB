/*

ircDDB

Copyright (C) 2010   Michael Dirska, DL1BFF (dl1bff@mdx.de)

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

*/


package net.ircDDB;

import java.util.Date;
import java.util.LinkedList;
import java.util.Properties;
import java.util.regex.Pattern;


public interface IRCDDBExtApp extends IRCApplication, Runnable
{

	public class DatabaseObject
	{
		public Date modTime;
		public String key;
		public String value;
	}

	public class UpdateResult
	{
		public boolean keyWasNew;
		public DatabaseObject newObj;
		public DatabaseObject oldObj;
	}

	public boolean setParams( Properties p,  int numberOfTables,
		Pattern[] keyPattern, Pattern[] valuePattern );

	public UpdateResult dbUpdate( int tableID, Date d, String key, String value, String ircUser );

	public LinkedList<DatabaseObject> getDatabaseObjects( 
		int tableID, Date beginDate, int numberOfObjects );

	public Date getLastEntryDate(int tableID);

	public boolean needsDatabaseUpdate(int tableID);

	public void setCurrentServerNick(String nick);
}


