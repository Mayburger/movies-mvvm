package com.nacoda.moviesmvvm.data.model;

import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by Mayburger on 1/9/18.
 */

public final class Casts {

    private String id;
    private List<Cast> cast;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    public static final class Cast{
        @Nullable
        private String cast_id;

        @Nullable
        public String getCast_id() {
            return cast_id;
        }

        public void setCast_id(@Nullable String cast_id) {
            this.cast_id = cast_id;
        }

        @Nullable
        public String getCharacter() {
            return character;
        }

        public void setCharacter(@Nullable String character) {
            this.character = character;
        }

        @Nullable
        public String getCredit_id() {
            return credit_id;
        }

        public void setCredit_id(@Nullable String credit_id) {
            this.credit_id = credit_id;
        }

        @Nullable
        public String getGender() {
            return gender;
        }

        public void setGender(@Nullable String gender) {
            this.gender = gender;
        }

        @Nullable
        public String getId() {
            return id;
        }

        public void setId(@Nullable String id) {
            this.id = id;
        }

        @Nullable
        public String getName() {
            return name;
        }

        public void setName(@Nullable String name) {
            this.name = name;
        }

        @Nullable
        public String getOrder() {
            return order;
        }

        public void setOrder(@Nullable String order) {
            this.order = order;
        }

        @Nullable
        public String getProfile_path() {
            return profile_path;
        }

        public void setProfile_path(@Nullable String profile_path) {
            this.profile_path = profile_path;
        }

        @Nullable
        private String character;
        @Nullable
        private String credit_id;
        @Nullable
        private String gender;
        @Nullable
        private String id;
        @Nullable
        private String name;
        @Nullable
        private String order;
        @Nullable
        private String profile_path;
    }

}
