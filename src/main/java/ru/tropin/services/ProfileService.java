package ru.tropin.services;

import ru.tropin.form.ProfileForm;
import ru.tropin.model.User;

public interface ProfileService {
    public void updateProfile(ProfileForm profileForm, Long id);
}
