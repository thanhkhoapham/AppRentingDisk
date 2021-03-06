package com.xdpm.ui;

import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JTabbedPane;

import SQLServerConnUtils.SQLServerConnUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class UI_Main extends JFrame {

	private JMenuBar menuBar;
	private JMenu mnThueDia;
	private JMenu mnDatTruoc;
	private JMenu mnTraTre;
	private JMenu mnQuanLy;
	private JMenu mnBaoCao;
	private JMenu mnKhac;
	private JMenuItem jmiThueDia;
	private JMenuItem jmiTraDia;
	private JMenuItem jmiKTTTDia;
	private JMenuItem jmiThemDatTruoc;
	private JMenuItem jmiHuyDatTruoc;
	private JMenuItem jmiThanhToan;
	private JMenuItem jmiQLTuaDe;
	private JMenuItem jmiQLKhachHang;
	private JMenu jmiBCKhachHang;
	private JMenu jmiBCTuaDe;
	private JMenuItem jmiCapNhatGiaThue;
	private JMenuItem jmiCapNhatNgayThue;
	private JMenuItem jmiQLDia;
	private JButton btnDangNhap;
	private UI_ThueDia pnlThueDia;
	private UI_TraDia pnlTraDia;
	private JTabbedPane tabbedPane;
	private UI_TTTreHan pnlTTTreHan;
	private UI_DatTruoc pnlDatTruoc;
	private UI_HuyDatTruoc pnlHuyDatTruoc;
	private JMenuItem jmiBCTatCaKH;
	private JMenuItem jmiBCKhChuaTraDia;
	private JMenuItem jmiKHDangNo;
	private JMenuItem jmiQLTuaDe_Chitiet;
	private UI_QL_Dia pnlQLDia;
	private UI_QL_TuaDe pnlQLTua;
	private UI_QL_KhachHang pnlQLKhachHang;
	private JMenuItem jmiTTCBDia;
	private JMenuItem jmiDiaDangThue;
	private JMenuItem jmiDiaDangGiu;
	private JMenuItem jmiDiaTrenKe;
	private JMenuItem jmiTongSoDia;
	private JMenuItem jmiBCKhSoHuuDia;

	public UI_Main() {
		Font font = new Font("Tahoma", Font.PLAIN, 16);
		Font font2 = new Font("Tahoma", Font.PLAIN, 14);

		setTitle("Qu???n l?? thu?? ????a");
		setSize(1100, 700);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		ImageIcon mainIcon = new ImageIcon("image/disk.png");
		setIconImage(mainIcon.getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnThueDia = new JMenu("Thu?? - Tr??? ????a");
		mnThueDia.setFont(font);
		menuBar.add(mnThueDia);

		mnDatTruoc = new JMenu("?????t tr?????c");
		mnDatTruoc.setFont(font);
		menuBar.add(mnDatTruoc);

		mnTraTre = new JMenu("Tr??? tr???");
		mnTraTre.setFont(font);
		menuBar.add(mnTraTre);

		mnQuanLy = new JMenu("Qu???n l??");
		mnQuanLy.setFont(font);
		menuBar.add(mnQuanLy);

		// ==========================================================
		jmiThueDia = new JMenuItem("Thu?? ????a", new ImageIcon("image/Thue.png"));
		jmiThueDia.setFont(font2);
		mnThueDia.add(jmiThueDia);

		jmiTraDia = new JMenuItem("Tr??? ????a", new ImageIcon("image/TraDia.png"));
		jmiTraDia.setFont(font2);
		mnThueDia.add(jmiTraDia);

		jmiKTTTDia = new JMenuItem("Ki???m tra tr???ng th??i ????a", new ImageIcon("image/KtraTrangThai.png"));
		jmiKTTTDia.setFont(font2);
		mnThueDia.add(jmiKTTTDia);

		jmiThemDatTruoc = new JMenuItem("Th??m ?????t tr?????c", new ImageIcon("image/ThemDatTruoc.png"));
		jmiThemDatTruoc.setFont(font2);
		mnDatTruoc.add(jmiThemDatTruoc);

		jmiHuyDatTruoc = new JMenuItem("H???y ?????t tr?????c", new ImageIcon("image/HuyDatTruoc.png"));
		jmiHuyDatTruoc.setFont(font2);
		mnDatTruoc.add(jmiHuyDatTruoc);

		jmiThanhToan = new JMenuItem("Thanh to??n ph?? tr???", new ImageIcon("image/money.png"));
		jmiThanhToan.setFont(font2);
		mnTraTre.add(jmiThanhToan);

		jmiQLKhachHang = new JMenuItem("Qu???n l?? kh??ch h??ng", new ImageIcon("image/customer.png"));
		jmiQLKhachHang.setFont(font2);
		mnQuanLy.add(jmiQLKhachHang);

		jmiQLTuaDe_Chitiet = new JMenuItem("Xem chi ti???t t???a phim/game", new ImageIcon("image/ChiTietTua.png"));
		jmiQLTuaDe_Chitiet.setFont(font2);
		mnQuanLy.add(jmiQLTuaDe_Chitiet);

		// ==========================================================
		mnThueDia.setPreferredSize(new Dimension(165, 40));
		mnDatTruoc.setPreferredSize(new Dimension(165, 40));
		mnTraTre.setPreferredSize(new Dimension(165, 40));
		mnQuanLy.setPreferredSize(new Dimension(165, 40));
		jmiThemDatTruoc.setPreferredSize(new Dimension(165, 40));
		jmiHuyDatTruoc.setPreferredSize(new Dimension(165, 40));
		// ==========================================================
		mnThueDia.setIcon(new ImageIcon("image/disk.png"));
		mnDatTruoc.setIcon(new ImageIcon("image/DatTruoc.png"));
		mnTraTre.setIcon(new ImageIcon("image/money.png"));
		mnQuanLy.setIcon(new ImageIcon("image/quanLy.png"));
		getContentPane().setLayout(null);

		JPanel pnlDangNhap = new JPanel();
		pnlDangNhap.setBackground(Color.WHITE);
		pnlDangNhap.setBounds(10, 561, 1066, 50);
		getContentPane().add(pnlDangNhap);
		pnlDangNhap.setLayout(null);

		btnDangNhap = new JButton("????ng nh???p qu???n l??");
		btnDangNhap.setBounds(896, 10, 142, 30);
		pnlDangNhap.add(btnDangNhap);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 1066, 541);
		tabbedPane.setFont(font);
		getContentPane().add(tabbedPane);

		// ==========================================================
		btnDangNhap.addActionListener(e -> {
			if (btnDangNhap.getText().equals("????ng nh???p qu???n l??")) {
				UI_Login loginUI = new UI_Login(this, true);
				loginUI.setVisible(true);
			} else {
				changeUI(false);
				repaint();
				validate();
			}
		});

		// ==========================================================
		pnlThueDia = new UI_ThueDia();
		jmiThueDia.addActionListener(e -> {
			tabbedPane.removeAll();
			tabbedPane.addTab("Thu?? ????a", new ImageIcon("image/Thue.png"), pnlThueDia, "Thu?? ????a");
		});

		pnlTraDia = new UI_TraDia();
		jmiTraDia.addActionListener(e -> {
			tabbedPane.removeAll();
			tabbedPane.addTab("Tr??? ????a", new ImageIcon("image/TraDia.png"), pnlTraDia, "Tr??? ????a");
		});

		jmiKTTTDia.addActionListener(e -> {
			UI_KiemTraDia ui_ktdia = new UI_KiemTraDia(this, true);
			ui_ktdia.setVisible(true);
		});

		pnlTTTreHan = new UI_TTTreHan();
		jmiThanhToan.addActionListener(e -> {
			tabbedPane.removeAll();
			tabbedPane.addTab("Thanh to??n tr??? h???n", new ImageIcon("image/money.png"), pnlTTTreHan,
					"Thanh to??n tr??? h???n");
		});

		pnlDatTruoc = new UI_DatTruoc();
		jmiThemDatTruoc.addActionListener(e -> {
			tabbedPane.removeAll();
			tabbedPane.addTab("?????t tr?????c t???a ?????", new ImageIcon("image/ThemDatTruoc.png"), pnlDatTruoc,
					"?????t tr?????c t???a ?????");
		});

		pnlHuyDatTruoc = new UI_HuyDatTruoc();
		jmiHuyDatTruoc.addActionListener(e -> {
			tabbedPane.removeAll();
			tabbedPane.addTab("H???y ?????t tr?????c", new ImageIcon("image/HuyDatTruoc.png"), pnlHuyDatTruoc, "H???y ?????t tr?????c");
		});

		jmiQLTuaDe_Chitiet.addActionListener(e -> {
			JFrame chiTietTuaDe = new UI_QL_ChiTietTuaDe();
			chiTietTuaDe.setVisible(true);
		});

		pnlQLKhachHang = new UI_QL_KhachHang();
		jmiQLKhachHang.addActionListener(e -> {
			tabbedPane.removeAll();
			tabbedPane.addTab("Qu???n l?? th??ng tin kh??ch", new ImageIcon("image/customer.png"), pnlQLKhachHang,
					"Qu???n l?? th??ng tin kh??ch");
		});
	}

	public void changeUI(boolean isManager) {
		Font font = new Font("Tahoma", Font.PLAIN, 16);
		Font font2 = new Font("Tahoma", Font.PLAIN, 14);
		if (isManager) {
			mnBaoCao = new JMenu("B??o c??o");
			mnBaoCao.setFont(font);
			menuBar.add(mnBaoCao);

			mnKhac = new JMenu("Kh??c");
			mnKhac.setFont(font);
			menuBar.add(mnKhac);

			// ==========================================================
			jmiQLDia = new JMenuItem("Qu???n l?? ????a", new ImageIcon("image/QLDia.png"));
			jmiQLDia.setFont(font2);
			mnQuanLy.add(jmiQLDia);

			jmiBCKhachHang = new JMenu("B??o c??o kh??ch h??ng");
			jmiBCKhachHang.setFont(font2);
			mnBaoCao.add(jmiBCKhachHang);

			jmiBCTatCaKH = new JMenuItem("T???t c??? kh??ch h??ng", new ImageIcon("image/disk.png"));
			jmiBCTatCaKH.setFont(font2);
			jmiBCKhachHang.add(jmiBCTatCaKH);

			jmiBCKhChuaTraDia = new JMenuItem("Kh??ch h??ng ??ang thu?? ????a", new ImageIcon("image/disk.png"));
			jmiBCKhChuaTraDia.setFont(font2);
			jmiBCKhachHang.add(jmiBCKhChuaTraDia);

			jmiKHDangNo = new JMenuItem("Kh??ch h??ng ??ang n???", new ImageIcon("image/disk.png"));
			jmiKHDangNo.setFont(font2);
			jmiBCKhachHang.add(jmiKHDangNo);

			jmiBCKhSoHuuDia = new JMenuItem("Kh??ch h??ng ??ang s??? h???u s??? l?????ng ????a", new ImageIcon("image/disk.png"));
			jmiBCKhSoHuuDia.setFont(font2);
			jmiBCKhachHang.add(jmiBCKhSoHuuDia);

			jmiBCTuaDe = new JMenu("B??o c??o t???a ?????");
			jmiBCTuaDe.setFont(font2);
			mnBaoCao.add(jmiBCTuaDe);

			jmiTTCBDia = new JMenuItem("Th??ng tin c?? b???n", new ImageIcon("image/disk.png"));
			jmiTTCBDia.setFont(font2);
			jmiBCTuaDe.add(jmiTTCBDia);

			jmiDiaDangThue = new JMenuItem("S??? ????a ??ang thu??", new ImageIcon("image/disk.png"));
			jmiDiaDangThue.setFont(font2);
			jmiBCTuaDe.add(jmiDiaDangThue);

			jmiDiaDangGiu = new JMenuItem("S??? ????a ??ang gi???", new ImageIcon("image/disk.png"));
			jmiDiaDangGiu.setFont(font2);
			jmiBCTuaDe.add(jmiDiaDangGiu);

			jmiDiaTrenKe = new JMenuItem("S??? ????a tr??n k???", new ImageIcon("image/disk.png"));
			jmiDiaTrenKe.setFont(font2);
			jmiBCTuaDe.add(jmiDiaTrenKe);

			jmiCapNhatGiaThue = new JMenuItem("C???p nh???t gi?? thu??", new ImageIcon("image/giaThue.png"));
			jmiCapNhatGiaThue.setFont(font2);
			mnKhac.add(jmiCapNhatGiaThue);

			jmiCapNhatNgayThue = new JMenuItem("C???p nh???t s??? ng??y thu??", new ImageIcon("image/clock.png"));
			jmiCapNhatNgayThue.setFont(font2);
			mnKhac.add(jmiCapNhatNgayThue);

			jmiQLTuaDe = new JMenuItem("Qu???n l?? t???a ?????", new ImageIcon("image/QLTuaDe.png"));
			jmiQLTuaDe.setFont(font2);
			mnQuanLy.add(jmiQLTuaDe);
			// ==========================================================
			mnBaoCao.setPreferredSize(new Dimension(165, 40));
			mnKhac.setPreferredSize(new Dimension(165, 40));

			mnBaoCao.setIcon(new ImageIcon("image/report.png"));
			mnKhac.setIcon(new ImageIcon("image/update.png"));
			jmiBCKhachHang.setIcon(new ImageIcon("image/report.png"));
			jmiBCTuaDe.setIcon(new ImageIcon("image/report.png"));

			jmiBCTatCaKH.setPreferredSize(new Dimension(210, 40));
			jmiBCKhChuaTraDia.setPreferredSize(new Dimension(210, 40));
			jmiKHDangNo.setPreferredSize(new Dimension(210, 40));

			tabbedPane.removeAll();
			btnDangNhap.setText("????ng xu???t");

			// ===========Bat su kien ben trong admin
			pnlQLDia = new UI_QL_Dia();
			pnlQLTua = new UI_QL_TuaDe();

			jmiCapNhatGiaThue.addActionListener(e -> {
				tabbedPane.removeAll();
				JFrame jfrmCapNhapGiaThue = new UI_CapNhat_GiaThue();
				jfrmCapNhapGiaThue.setVisible(true);
			});
			jmiCapNhatNgayThue.addActionListener(e -> {
				tabbedPane.removeAll();
				JFrame jfrmCapNhapNgayThue = new UI_CapNhat_NgayThue();
				jfrmCapNhapNgayThue.setVisible(true);
			});

			jmiQLDia.addActionListener(e -> {
				tabbedPane.removeAll();
				tabbedPane.addTab("Qu???n l?? ????a", new ImageIcon("image/disk.png"), pnlQLDia, "Qu???n l?? ????a");
			});

			jmiQLTuaDe.addActionListener(e -> {
				tabbedPane.removeAll();
				tabbedPane.addTab("Qu???n l?? t???a ?????", new ImageIcon("image/disk.png"), pnlQLTua, "Qu???n l?? t???a ?????");
			});

			// =============Bao cao dia
			jmiTTCBDia.addActionListener(e -> {
				Map<String, Object> parameters = new HashMap<String, Object>();
				xuatBaoCao("BaoCao_ThongTinTuaDe.jrxml", parameters);
			});

			// Bao Cao KH
			jmiBCTatCaKH.addActionListener(e -> {
				Map<String, Object> parameters = new HashMap<String, Object>();
				xuatBaoCao("BaoCaoTTKH.jrxml", parameters);
			});
			jmiBCKhChuaTraDia.addActionListener(e -> {
				Map<String, Object> parameters = new HashMap<String, Object>();
				xuatBaoCao("BaoCaoDanhSachDiaDangQuaHanCuaKH.jrxml", parameters);
			});
			jmiKHDangNo.addActionListener(e -> {
				Map<String, Object> parameters = new HashMap<String, Object>();
				xuatBaoCao("BaoCaoKhoanPhiNo.jrxml", parameters);
			});
			jmiBCKhSoHuuDia.addActionListener(e -> {
				Map<String, Object> parameters = new HashMap<String, Object>();
				xuatBaoCao("SoLuongDiaDuocThue.jrxml", parameters);
			});
//			jmiBCTatCaKH jmiBCKhChuaTraDia jmiKHDangNo
			// Bao cao Dia
			jmiTTCBDia.addActionListener(e -> {
				Map<String, Object> parameters = new HashMap<String, Object>();
				xuatBaoCao("BaoCao_ThongTinTuaDe.jrxml", parameters);
			});
			jmiDiaDangGiu.addActionListener(e -> {
				Map<String, Object> parameters = new HashMap<String, Object>();
				xuatBaoCao("BaoCao_SoLuongDiaDatTruoc.jrxml", parameters);
			});
			jmiDiaDangThue.addActionListener(e -> {
				Map<String, Object> parameters = new HashMap<String, Object>();
				xuatBaoCao("BaoCao_SoLuongDiaDangThueTheoTuaDe.jrxml", parameters);
			});
			jmiDiaTrenKe.addActionListener(e -> {
				Map<String, Object> parameters = new HashMap<String, Object>();
				xuatBaoCao("BaoCao_SoLuongDiaTrenKe.jrxml", parameters);
			});
		} else {
			mnQuanLy.add(jmiQLTuaDe_Chitiet);
			menuBar.remove(mnBaoCao);
			menuBar.remove(mnKhac);
			mnQuanLy.remove(jmiQLDia);
			mnQuanLy.remove(jmiQLTuaDe);
			tabbedPane.removeAll();
			btnDangNhap.setText("????ng nh???p qu???n l??");
		}
	}

	protected void xuatBaoCao(String string, Map<String, Object> parameters) {
		try {
			JasperReport jasperReport = JasperCompileManager.compileReport("src/main/java/com/xdpm/report/" + string);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
					SQLServerConnUtils.getSQLServerConnection_SQLJDBC());
			JasperViewer.viewReport(jasperPrint, false);
		} catch (JRException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
