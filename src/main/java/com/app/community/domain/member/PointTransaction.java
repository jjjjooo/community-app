package com.app.community.domain.member;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PointTransaction {

    private @Nullable Long id;
    private @NotNull Long memberId;
    private @NotNull String description;
    private @NotNull int changeValue;
    private @NotNull String relatePath;
}
