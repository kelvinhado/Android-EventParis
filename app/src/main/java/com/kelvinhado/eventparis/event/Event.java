package com.kelvinhado.eventparis.event;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Kelvin HADO
 * on 13/11/15
 * http://www.github.com/kelvinhado
 */

public class Event {

    private String recordid;
    private Fields fields;

    @Override
    public String toString() {
        return "Event{" +
                "recordid='" + recordid + '\'' +
                ", fields=" + fields +
                '}';

    }

    public String getRecordid() {
        return recordid;
    }

    public Fields getFields() {
        return fields;
    }

    public class Fields {
        private String lang;
        private String placename;
        private String pricing_info;
        private String image;
        private String image_thumb;
        private String date_start;
        private String date_end;
        private String updated_at;
        private String space_time_info;
        private String link;
        private String free_text;
        private String address;
        private String department;
        private String title;
        private String region;
        private String description;
        private Double[] latlon;

        @Override
        public String toString() {
            return "Fields{" +
                    "lang='" + lang + '\'' +
                    ", placename='" + placename + '\'' +
                    ", pricing_info='" + pricing_info + '\'' +
                    ", image='" + image + '\'' +
                    ", image_thumb='" + image_thumb + '\'' +
                    ", date_start='" + date_start + '\'' +
                    ", date_end='" + date_end + '\'' +
                    ", updated_at='" + updated_at + '\'' +
                    ", space_time_info='" + space_time_info + '\'' +
                    ", link='" + link + '\'' +
                    ", free_text='" + free_text + '\'' +
                    ", address='" + address + '\'' +
                    ", department='" + department + '\'' +
                    ", title='" + title + '\'' +
                    ", region='" + region + '\'' +
                    ", description='" + description + '\'' +
                    ", latlon=" + latlon +
                    '}';
        }

        public String getLang() {
            return lang;
        }

        public String getPlacename() {
            return placename;
        }

        public String getPricing_info() {
            return pricing_info;
        }

        public String getImage() {
            return image;
        }

        public String getImage_thumb() {
            return image_thumb;
        }

        public String getDate_start() {
            return date_start;
        }

        public String getDate_end() {
            return date_end;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public String getSpace_time_info() {
            return space_time_info;
        }

        public String getLink() {
            return link;
        }

        public String getFree_text() {
            return free_text;
        }

        public String getAddress() {
            return address;
        }

        public String getDepartment() {
            return department;
        }

        public String getTitle() {
            return title;
        }

        public String getRegion() {
            return region;
        }

        public String getDescription() {
            return description;
        }

        public Double[] getLatlon() {
            return latlon;
        }
    }





}
