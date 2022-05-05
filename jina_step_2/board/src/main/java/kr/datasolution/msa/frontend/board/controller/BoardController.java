package kr.datasolution.msa.frontend.board.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.datasolution.msa.frontend.board.dto.BoardDto;
import kr.datasolution.msa.frontend.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/* 게시물 관련 처리 Controller Layer */
@Tag(name = "Board API", description = "게시판 API")
@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    /** 게시물 관련 처리 Service Layer 연결 */
    /** 웹툴로 전송 값만 볼 것으로 불필요한 부분 삭제 */
    private final BoardService boardService;

    /** 게시물 목록 조회 화면 이동 */

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @Operation(summary = "게시물 목록 조회",description = "목록을 조회합니다.")
    @GetMapping("")
    public List<BoardDto> getViewBoardMain() {

        return boardService.getBoardList();
    }

    /** 게시물 상세 조회 화면 이동 */
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @Operation(summary = "게시물 상세 조회",description = "게시물 번호를 검색하며 해당 게시물을 조회합니다.")
    @GetMapping("{id}")
    public BoardDto getViewBoard(@PathVariable("id") int id) {

        return boardService.getBoard(id);
    }

    /** 게시물 등록 처리 */
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation",
                    content = @Content(schema = @Schema(implementation = BoardDto.class))),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @Operation(summary = "게시물 등록",description = "게시물 등록 합니다.")
    @PostMapping("")
    public void addBoard(@RequestBody BoardDto boardDto) {

        boardService.addBoard(boardDto);
    }

    /** 게시물 수정 처리 */
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation",
                    content = @Content(schema = @Schema(implementation = BoardDto.class))),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @Operation(summary = "게시물 수정",description = "게시물 번호를 검색하며 해당 게시물을 수정합니다.")
    @PutMapping("{id}/edit")
    public void modBoard(@PathVariable("id") int id, @RequestBody BoardDto boardDto) {

        boardService.getBoard(id);
        boardService.modBoard(boardDto);

    }

    /** 게시물 삭제 처리 */
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation",
                    content = @Content(schema = @Schema(implementation = BoardDto.class))),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @Operation(summary = "게시물 삭제",description = "게시물 번호를 검색하며 해당 게시물을 삭제합니다.")
    @DeleteMapping("{id}")
    public void removeBoard(@PathVariable("id") int id) {

        boardService.removeBoard(id);
    }
}