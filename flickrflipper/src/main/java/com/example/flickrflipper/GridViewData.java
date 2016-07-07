package com.example.flickrflipper;

/**
 * Created by tc on 7/7/16.
 */

public class GridViewData {
    int resourceId;
        String name,location,description;

        public GridViewData(int resourceId, String name, String location, String description) {
            this.resourceId = resourceId;
            this.name = name;
            this.location = location;
            this.description = description;
        }

        public int getResourceId() {
            return resourceId;
        }

        public String getName() {
            return name;
        }

        public String getLocation() {
            return location;
        }

        public String getDescription() {
            return description;
        }
}
