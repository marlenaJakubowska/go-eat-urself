package com.marspc.goeaturself.fast;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fast")
public class Fast {

    @Id
    @SequenceGenerator(
            name = "fast_sequence",
            sequenceName = "fast_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fast_sequence"
    )
    private Long id;


    @Column(name = "user_id")
    private Long userId;

    @Column(name = "previous_fast_id")
    private Long previousFastId;

    @Column(name = "target_fast_time")
    private Integer targetFastTime;

    @Column(name = "start_date_and_time")
    LocalDateTime startDateAndTime;

    @Column(name = "end_date_and_time")
    private LocalDateTime endDateAndTime;

    @Column(name = "is_active")
    private boolean isActive;


    public Fast() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPreviousFastId() {
        return previousFastId;
    }

    public void setPreviousFastId(Long previousFastId) {
        this.previousFastId = previousFastId;
    }

    public Integer getTargetFastTime() {
        return targetFastTime;
    }

    public void setTargetFastTime(Integer targetFastTime) {
        this.targetFastTime = targetFastTime;
    }

    public LocalDateTime getStartDateAndTime() {
        return startDateAndTime;
    }

    public void setStartDateAndTime(LocalDateTime tartDateAndTime) {
        this.startDateAndTime = tartDateAndTime;
    }

    public LocalDateTime getEndDateAndTime() {
        return endDateAndTime;
    }

    public void setEndDateAndTime(LocalDateTime endDateAndTime) {
        this.endDateAndTime = endDateAndTime;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Fast{" +
                "id=" + id +
                ", userId=" + userId +
                ", previousFastId=" + previousFastId +
                ", targetFastTime=" + targetFastTime +
                ", startDateAndTime=" + startDateAndTime +
                ", endDateAndTime=" + endDateAndTime +
                '}';
    }
}