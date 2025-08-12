package entity;

import jakarta.persistence.Embeddable;

/**
 * --------------------------------------------
 * Author: Shamodha Sahan
 * GitHub: https://github.com/shamodhas
 * Website: https://shamodha.com
 * --------------------------------------------
 * Created: 8/12/2025 10:54 AM
 * Project: hibernate-mvn
 * --------------------------------------------
 **/

@Embeddable
public class FullName {
    private String firstName;
    private String lastName;
}
