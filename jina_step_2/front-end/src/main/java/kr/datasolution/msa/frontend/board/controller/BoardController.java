package kr.datasolution.msa.frontend.board.controller;

import kr.datasolution.msa.frontend.board.dto.BoardDto;
import kr.datasolution.msa.frontend.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    /** 전체 등록 게시물 리스트 조회 */
    @GetMapping("")
    public String getViewBoardMain(ModelMap map) {
        map.put("list", boardService.getClientBoardList());
        return "board/main";
    }

    /** 지정 게시물 상세 조회 */
    @GetMapping("{id}")
    public String getViewBoard(@PathVariable("id") int id,
                               ModelMap map) {
        BoardDto boardDto =  boardService.getClientBoard(id).block();
        map.put("info", boardDto);
        return "board/info";
    }

    @GetMapping("new")
    public String getViewBoardNew() {
        return "board/new";
    }

    /** 게시물 등록 처리 */
    @PostMapping("")
    public String addBoard(@ModelAttribute BoardDto boardDto,
                           ModelMap map) {
        boardService.addClientBoard(boardDto);

        return "redirect:/board";
    }

    /**
     * 게시물 수정 화면 이동
     * @param id 게시물 ID
     * @param map View 로 전달할 ModelMap 객체
     * @return 게시물 수정 화면 경로
     */
    @GetMapping("{id}/edit")
    public String getViewBoardEdit(
            @PathVariable("id") int id,
            ModelMap map) {
        BoardDto boardDto =  boardService.getClientBoard(id).block();
        map.put("info", boardDto);
        return "board/edit";
    }

    /**
     * 게시물 수정 처리
     * @param boardDto 게시물 수정 데이터
     * @return 게시물 상세 조회 화면 호출
     */
    @PutMapping("{id}")
    public String modBoard(
            @PathVariable("id") int id,
            @ModelAttribute BoardDto boardDto) {
        boardDto.setId(id);
        boardService.modBoard(boardDto);

        return "redirect:/board/" + id;
    }


    /** 게시물 삭제 처리 */
    @DeleteMapping("{id}")
    public String removeBoard(
            @PathVariable("id") int id) {
        boardService.removeClientBoard(id);
        return "redirect:/board";
    }

}