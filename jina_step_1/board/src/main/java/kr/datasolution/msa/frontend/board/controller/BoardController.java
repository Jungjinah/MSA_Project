package kr.datasolution.msa.frontend.board.controller;

import io.swagger.v3.oas.annotations.Operation;
import kr.datasolution.msa.frontend.board.dto.BoardDto;
import kr.datasolution.msa.frontend.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 게시물 관련 처리 Controller Layer
 */
@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    /** 게시물 관련 처리 Service Layer 연결 */
    private final BoardService boardService;

    /**
     * 게시물 목록 조회 화면 이동
     * @param map View 로 전달할 ModelMap 객체
     * @return 게시물 목록 조회 화면 경로
     */
    @Operation(summary = "게시물 목록 조회")
    @GetMapping("")
    public List<BoardDto> getViewBoardMain() {

        return boardService.getBoardList();
    }

    /**
     * 게시물 상세 조회 화면 이동
     * @param id 게시물 ID
     * @param map View 로 전달할 ModelMap 객체
     * @return 게시물 상세 조회 화면 경로
     */
    @Operation(summary = "게시물 상세 조회")
    @GetMapping("{id}")
    public String getViewBoard(
            @PathVariable("id") int id,
            ModelMap map) {
        map.put("info", boardService.getBoard(id));
        return "board/info";
    }

//    /**
//     * 게시물 등록 화면 이동
//     * @return 게시물 등록 화면 경로
//     */
//    @GetMapping("new")
//    public String getViewBoardNew() {
//        return "board/new";
//    }

//    /**
//     * 게시물 수정 화면 이동
//     * @param id 게시물 ID
//     * @param map View 로 전달할 ModelMap 객체
//     * @return 게시물 수정 화면 경로
//     */
//    @GetMapping("{id}/edit")
//    public String getViewBoardEdit(
//            @PathVariable("id") int id,
//            ModelMap map) {
//        map.put("info", boardService.getBoard(id));
//        return "board/edit";
//    }

    /**
     * 게시물 등록 처리
     *
     * @param boardDto 게시물 등록 데이터
     * @param map      View 로 전달할 ModelMap 객체
     * @return 게시물 상세 조회 화면 호출
     */
    @Operation(summary = "게시물 등록")
    @PostMapping("")
    public int addBoard(
            @RequestBody BoardDto boardDto,
            ModelMap map) {
        return boardService.addBoard(boardDto);

        //return "redirect:/board/" + boardDto.getId();
    }

    /**
     * 게시물 수정 처리
     *
     * @param boardDto 게시물 수정 데이터
     * @param map      View 로 전달할 ModelMap 객체
     * @return 게시물 상세 조회 화면 호출
     */
    @Operation(summary = "게시물 수정")
    @PutMapping("{id}")
    public int modBoard(
            @PathVariable("id") int id,
            @RequestBody BoardDto boardDto,
            ModelMap map) {
        boardDto.setId(id);
        return boardService.modBoard(boardDto);
        //return "redirect:/board/" + id;
    }

    /**
     * 게시물 삭제 처리
     *
     * @param id  삭제 대상 게시물 ID
     * @param map View 로 전달할 ModelMap 객체
     * @return 게시물 목록 조회 화면 호출
     */
    @Operation(summary = "게시물 삭제")
    @DeleteMapping("{id}")
    public int removeBoard(
            @PathVariable("id") int id,
            ModelMap map) {
        return boardService.removeBoard(id);
        //return "redirect:/board";
    }
}
