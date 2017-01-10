package ni.org.ics.zikapositivas.appmovil.helpers;

import java.util.Date;

import ni.org.ics.zikapositivas.appmovil.domain.users.Authority;
import ni.org.ics.zikapositivas.appmovil.domain.users.AuthorityId;
import ni.org.ics.zikapositivas.appmovil.domain.users.UserSistema;
import ni.org.ics.zikapositivas.appmovil.utils.MainDBConstants;

import android.content.ContentValues;
import android.database.Cursor;

public class UserSistemaHelper {
	
	public static ContentValues crearUserSistemaContentValues(UserSistema user){
		ContentValues cv = new ContentValues();
		cv.put(MainDBConstants.username, user.getUsername());
		if (user.getCreated() != null) cv.put(MainDBConstants.created, user.getCreated().getTime());
		if (user.getModified() != null) cv.put(MainDBConstants.modified, user.getModified().getTime());
		if (user.getLastAccess() != null) cv.put(MainDBConstants.lastAccess, user.getLastAccess().getTime());
		cv.put(MainDBConstants.password, user.getPassword());
		cv.put(MainDBConstants.completeName, user.getCompleteName());
		cv.put(MainDBConstants.email, user.getEmail());
		cv.put(MainDBConstants.enabled, user.getEnabled());
		cv.put(MainDBConstants.accountNonExpired, user.getAccountNonExpired());
		cv.put(MainDBConstants.credentialsNonExpired, user.getCredentialsNonExpired());
		if (user.getLastCredentialChange() != null) cv.put(MainDBConstants.lastCredentialChange, user.getLastCredentialChange().getTime());
		cv.put(MainDBConstants.accountNonLocked, user.getAccountNonLocked());
		cv.put(MainDBConstants.createdBy, user.getCreatedBy());
		cv.put(MainDBConstants.modifiedBy, user.getModifiedBy());
		return cv; 
	}	
	
	public static UserSistema crearUserSistema(Cursor cursorUser){
		
		UserSistema mUser = new UserSistema();
		mUser.setUsername(cursorUser.getString(cursorUser.getColumnIndex(MainDBConstants.username)));
		if(cursorUser.getLong(cursorUser.getColumnIndex(MainDBConstants.created))>0) mUser.setCreated(new Date(cursorUser.getLong(cursorUser.getColumnIndex(MainDBConstants.created))));
		if(cursorUser.getLong(cursorUser.getColumnIndex(MainDBConstants.modified))>0) mUser.setModified(new Date(cursorUser.getLong(cursorUser.getColumnIndex(MainDBConstants.modified))));
		if(cursorUser.getLong(cursorUser.getColumnIndex(MainDBConstants.lastAccess))>0) mUser.setLastAccess(new Date(cursorUser.getLong(cursorUser.getColumnIndex(MainDBConstants.lastAccess))));
		mUser.setPassword(cursorUser.getString(cursorUser.getColumnIndex(MainDBConstants.password)));
		mUser.setCompleteName(cursorUser.getString(cursorUser.getColumnIndex(MainDBConstants.completeName)));
		mUser.setEmail(cursorUser.getString(cursorUser.getColumnIndex(MainDBConstants.email)));
		mUser.setEnabled(cursorUser.getInt(cursorUser.getColumnIndex(MainDBConstants.enabled))>0);
		mUser.setAccountNonExpired(cursorUser.getInt(cursorUser.getColumnIndex(MainDBConstants.accountNonExpired))>0);
		mUser.setCredentialsNonExpired(cursorUser.getInt(cursorUser.getColumnIndex(MainDBConstants.credentialsNonExpired))>0);
		if(cursorUser.getLong(cursorUser.getColumnIndex(MainDBConstants.lastCredentialChange))>0) mUser.setLastCredentialChange(new Date(cursorUser.getLong(cursorUser.getColumnIndex(MainDBConstants.lastCredentialChange))));
		mUser.setAccountNonLocked(cursorUser.getInt(cursorUser.getColumnIndex(MainDBConstants.accountNonLocked))>0);
		mUser.setCreatedBy(cursorUser.getString(cursorUser.getColumnIndex(MainDBConstants.createdBy)));
		mUser.setModifiedBy(cursorUser.getString(cursorUser.getColumnIndex(MainDBConstants.modifiedBy)));
		return mUser;
	}
	
	public static ContentValues crearRolValues(Authority rol){
		ContentValues cv = new ContentValues();
		cv.put(MainDBConstants.username, rol.getAuthId().getUsername());
		cv.put(MainDBConstants.role, rol.getAuthId().getAuthority());
		return cv; 
	}	
	
	public static Authority crearRol(Cursor cursorRol){
		
		Authority mRol = new Authority();
		mRol.setAuthId(new AuthorityId(cursorRol.getString(cursorRol.getColumnIndex(MainDBConstants.username)),cursorRol.getString(cursorRol.getColumnIndex(MainDBConstants.role))));
		return mRol;
	}
	
}
