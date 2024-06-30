package com.app.community.domain.member;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Getter
public class Activity {
    private @Nullable Long id;
    private @NotNull Long memberId;
    private @NotNull String description;
    private @NotNull String relatePath;
}
