package com.solvd.app.carina.demo.db.mappers;

import com.solvd.app.carina.demo.db.models.UserPreference;

public interface UserPreferenceMapper {

	void create(UserPreference userPreference);

	UserPreference findById(Long id);

}
