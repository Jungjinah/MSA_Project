package kr.datasolution.msa.frontend.board.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 게시물 DTO CLASS
 */
@Data
public class BoardDto {

    /** 게시물 ID */
    @Schema(description = "게시물 등록 번호")
    private int id;

    /** 제목 */
    @Schema(description = "게시물 제목")
    private String title;

    /** 내용 */
    @Schema(description = "게시물 내용")
    private String contents;

    /** 등록일시 */
    @Schema(description = "게시물 등록일시", example = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDt;

    /** 수정일시 */
    @Schema(description = "게시물 수정일시", example = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updDt;
}
