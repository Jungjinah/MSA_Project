package kr.datasolution.msa.frontend.board.service;

import kr.datasolution.msa.frontend.board.dto.BoardDto;
import kr.datasolution.msa.frontend.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 게시물 관련 처리 Service Layer
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {
    private final BoardMapper boardMapper;

    /**
     * 전체 게시물 리스트 조회
     * @return 전체 게시물 리스트
     */
    public List<BoardDto> getBoardList() {
        return boardMapper.findAll();
    }

    /**
     * 지정 게시물 상세 조회
     * @param id 게시물 ID
     * @return 지정 게시물
     */
    public BoardDto getBoard(int id) {
        return boardMapper.findById(id);
    }

    /**
     * 게시물 등록 처리
     *
     * @param boardDto 게시물 등록 데이터
     * @return
     */
    public int addBoard(BoardDto boardDto) {
        int count = boardMapper.save(boardDto);
        return count;
        //log.info("BOARD INSERT COUNT : {}", count);
    }

    /**
     * 게시물 수정 처리
     * @param boardDto 게시물 수정 데이터
     */
    public int modBoard(BoardDto boardDto) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("dto", boardDto);
        int count = boardMapper.update(boardDto);
        return count;
        //log.info("BOARD UPDATE COUNT : {}", count);
    }

    /**
     * 게시물 삭제 처리
     * @param id 게시물 ID
     */
    public int removeBoard(int id) {
        int count = boardMapper.deleteById(id);
        return count;
        //log.info("BOARD DELETE COUNT : {}", count);
    }
}
