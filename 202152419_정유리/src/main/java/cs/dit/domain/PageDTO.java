package cs.dit.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	private int startPage; //�� ȭ���� ù ������ ��ȣ
	private int endPage;  //��ü �Խñ��� ������ ������ ��ȣ
	private boolean prev, next; //���������̼� ��ũ�� ǥ�õǴ� ����, ���� ��ũ ǥ��
	
	private int total; //��ü �Խñ��� ����
	private Criteria cri; //pageNum, amount�� ������ ��ü
	
	public PageDTO(Criteria cri, int total) { //�ʵ尡 �ִ� ������
		this.cri = cri;
		this.total = total;
		
		int numOfPages = 5; //�� ȭ�鿡 �������� �������� ��
		
		//������ ������ ��� - ������ ����� �ƴϳ� endPage ����� ���� �̸� ���
		this.endPage = (int)Math.ceil((float)cri.getPageNum()/(float)numOfPages)*numOfPages;
		//ù ������ ���
		this.startPage = this.endPage - (numOfPages-1);
		
		//��ü ���ڵ��� ���� ����� ���� ������ ������ ���
		int realEnd = (int)Math.ceil((float)total/(float)cri.getAmount());
		//������ ����� ������ �������� ���� ������ ���������� ũ�� ���� �������� ����ǵ��� ������������ ����
		this.endPage = this.endPage> realEnd? realEnd:this.endPage;
		
		//ù �������� 1���� ũ��, �� (�� ȭ���� ������ ���� 5�� ���) 6, 11, 16... �� �Ǹ� prev�� ǥ��
		this.prev = this.startPage > 1;
		//next ��ũ�� realEnd�� ����ȣ ���� ū��쿡�� ����
		this.next = this.endPage<realEnd;
		
	}
}