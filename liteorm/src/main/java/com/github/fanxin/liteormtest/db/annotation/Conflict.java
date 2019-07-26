package com.github.fanxin.liteormtest.db.annotation;

import com.github.fanxin.liteormtest.db.enums.Strategy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 冲突策略
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Conflict {
    public Strategy value();
}
