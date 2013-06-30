package sig.icom.userservice;

import java.util.Random;

public class Test {
	private static IcomUserService icomUserService = new IcomUserService();
	public static void main(String[] args){
		Random r = new Random();
		for (int i = 0; i < listFacemousPlace.length; i ++){
			int nc = r.nextInt(30);
			for (int j = 0;j < nc; j ++){
				int uc = r.nextInt(1269);
				int cs = r.nextInt(listFamoustComment.length);
				icomUserService.addComment("http://hust.se.vtio.owl#" + listFacemousPlace[i], "kenfriends" + uc + "@gmail.com", listFamoustComment[cs], 123, 0);
			}
		}
	}
	private  void logInAllFriend(){
		for (int i = 0; i < listUserName.length; i ++){
			icomUserService.loginByFace("kenfriends" + i + "@gmail.com", listUserName[i]);
		}
	}
	private static String [] listFamoustComment = {
		"Dia diem tuyet voi :D",
		"Tuyệt vời",
		"Rất nổi tiếng",
		"Đã tới đây 1 lần",
		"Ủng hộ nào ",
		"Very good! <3",
		"Hay",
		"Dia diem noi tieng, tuyet voi",
		"Welcome~!"
	};
	private  String[] listUserName = {
	"Cún Béo",

	"Ha Ngoc Yen",

	"Thảo Râu",

	"Nguyen Thu Trang",

	"Tran Duc Dung",

	"Mai Thanh Trung",

	"Ban Ha Bang",

	"Gau Bac Cuc",

	"Jeremy Chu",

	"Nguyễn Nhi",

	"Nguyen Ba Thach",

	"Little Ki",

	"Dũng Hitech",

	"Duc Nguyen",

	"Hoang Minh Hung",

	"Le Duc Trung",

	"Nguyen Diu",

	"Nguyen Ngoc Bich",

	"Hoàng Manucian",

	"Lưu Quang Vũ",

	"Đông Nguyễn Đức",

	"Phan Anh Nguyên",

	"Zezo Ze Zo",

	"Lê Thị Bích Thuận",

	"Ngân Ngân",

	"Thành Nguyễn",

	"Le Tan Hung",

	"Vũ Hoàng",

	"Tran Dung",

	"Phan Thao",

	"Trang Nhjm",

	"Như Ngọc",

	"Hoàng Tuấn An",

	"Ngo Tu Anh",

	"Tuan Vuong",

	"Tran Quoc Huy",

	"Fg CÒi",

	"Phan Hiền",

	"Hoang Thu Trang",

	"Nghia Pham",

	"Quyen Dai Gia",

	"Linh Gấu",

	"Oanh Nguyễn",

	"Lân Nguyễn",

	"Ted Te Tua",

	"Zang Zang",

	"Nguyen Phi Hiep",

	"Cao Dung",

	"Tam Vu",

	"Toru Watanabe",

	"Nghiêm Tiến Viễn",

	"Ha Trung",

	"Thu Lan",

	"Thị Hương Giang Vũ",

	"Tuyen Tuti",

	"Thế Anh Nguyễn",

	"Nguyen Tien Thu",

	"Linh Kòi",

	"Giang Nguyen",

	"Linh Yoo",

	"Hai Duc",

	"Do Dang Quan",

	"Katsu Hama",

	"Thanh Nga",

	"Fall Gấu",

	"Ho Si Thang",

	"Hà Phương Miu",

	"Hoàng Anh Việt",

	"Hằng Lê Thúy",

	"Le Quoc Trung Trungquoc",

	"Nguyễn Thị Mai Hương",

	"Nguyen Huu Nam Duong",

	"Đồi Mé",

	"BK Itec",

	"Tran Tuan Vinh",

	"Nghia Minh Le",

	"Yến Su",

	"Oanh Ngoc Nguyen",

	"Phạm Đức Thành",

	"Ngô Văn Vĩ",

	"Nguyễn Quốc Minh",

	"Ham Ngủ",

	"Kani Chii",

	"Thuan Do Phan",

	"Vẹt Xinh",

	"Bùi Văn Thành",

	"Liu Nóng Nánh",

	"Trần Thị Huyền Trang",

	"Rathany Sam",

	"Cao Manh Dat",

	"Rùa Ngoan",

	"Nguyen Hong Phuong",

	"Bắc Phạm",

	"Sea Lavender",

	"Trinh Thu Hang",

	"Phan Hải Yến",

	"Guang Rong Chen",

	"Thuý Orchid",

	"Ngô Ngọc",

	"Tot Den",

	"Phạm Hồng Lê",

	"Cò Lả",

	"Giang Cận",

	"Thu Hà",

	"Nguoi Thich Khampha",

	"Vinh Đặng Công",

	"Churippu Mizuiro",

	"Le Huyen",

	"Little Cherry",

	"Oanh BooCat",

	"Nguyễn Đức Cảnh",

	"Le Hai Chau",

	"Phan Quang Vũ",

	"Minh Thuy Nguyen",

	"Nguyễn Đức Tâm",

	"Moon's Eyes",

	"Phạm Hà Duy",

	"Trà Đá",

	"Siêu Nhân Sứt",

	"Ly MiLo",

	"Nguyen Khanh Ly",

	"Tuan Eros",

	"Ngô Quang Vịnh",

	"Yen Tran",

	"Bờm Bụng Bự",

	"Hiệp Nghệ",

	"Steward Lalle Emma",

	"Tran Quynh",

	"Phương Trần",

	"Hiếu Trần",

	"Minh Nga Tran",

	"Hồng Phương",

	"Noel Buon",

	"Hoang Vu",

	"Ngo Huyen",

	"CoCo Chan",

	"Nguyen Kien Cuong",

	"Tocxoan Tranbuong",

	"Moon Nguyen BN",

	"Tùng Vui Vẻ",

	"Exmeranda III",

	"Ngọa Long",

	"Hai Nguyen Dinh",

	"Tani Lee",

	"Mars Kyo",

	"Kim Hue",

	"Phạm Khắc",

	"Nem Chua",

	"Dong Tuan Anh",

	"Hai Nguyen",

	"Vũ Anh",

	"Bk Bamboo",

	"Nguyễn Ngọc Giang",

	"Anh Sơn",

	"Lien Berry",

	"Hoàng Linh",

	"Nheo Na Na",

	"Tùng Trần",

	"Kien Phan",

	"ỐcTiêu Minh Thùy",

	"Quang Mai Anh",

	"Đông Tà Hmu",

	"Thơ Hana",

	"Thnh Cường",

	"Lê Xuân Thống Nhất",

	"Kún Băng",

	"Tiểu Bạch",

	"Giang Trung",

	"Đoàn Ngọc Sơn",

	"Nguyễn Thu CúcKoo",

	"Huy Tong",

	"Thủy Nâu",

	"Hoàng Yến",

	"Myna Be Heo",

	"Cỏ Dại",

	"Hỏi Làm Gì",

	"Mai Thuong",

	"Lê Hoàng Vũ",

	"Thắng Nguyễn",

	"Linh Truong",

	"Thanhvan Ho",

	"Tua Khìn",

	"Thùy Dương Dương",

	"Le Thuy",

	"Lucky Luke",

	"Tùng Nguyễn",

	"Gấu Xấu Xa",

	"Đắc Khánh",

	"Ho D. Chung",

	"Chestnut Chestnut",

	"Yanni Kun",

	"Tina Yêu Ck",

	"Hải Thanh Trần",

	"Toan Nguyen",

	"Hiền Nguyễn",

	"Phạm Trọng Nghĩa",

	"Nana Cat",

	"Huyhoang Ho",

	"Tu Inh Le",

	"Phong Ly",

	"Nguyen Ha",

	"Hien Ut",

	"Huyen Trang",

	"Chuyển FaBook",

	"Hoang Thanh Tung",

	"Anh Tung Hoang",

	"Huyền Nguyễn",

	"Phi Còi",

	"Van Trinh Thanh",

	"Nấm Kunkun",

	"Ngô Quỳnh Mai",

	"Truc Quynh",

	"Nhung Quỳnh",

	"Tạ Quỳnh",

	"Tran Thang",

	"Táo Tàu",

	"Hằng Bluemoon",

	"Cao Trà My",

	"Pham Tuan",

	"Thị Gà",

	"Trung Ngo",

	"Pham Dinh Phuong",

	"Ha Ngo",

	"Phan Đình Thái",

	"Le Duc Thai",

	"Huonggiang Nguyen",

	"Lee Diep",

	"Thanh Tâm Smile",

	"Lãng Quên",

	"Wáng Líng",

	"Dinh Hanh",

	"Thái Mai Trang",

	"Ngân Nguyễn",

	"Nguyễn Quỳnh",

	"Ngoc Lan Pham",

	"Thiên Sứ Khóc",

	"Quynh Anh",

	"BupBe Buon",

	"Nguyễn Ngọc Toàn",

	"Ana Ivanovic",

	"Hanh Ngan",

	"Hải Yến",

	"Khăc Fươc",

	"Harryz",

	"Link Đen",

	"Chung Ngốp",

	"Sao Tìm Thấy Tao",

	"Phạm Hòa",

	"Phan Tố Nga",

	"Kiều Anh Hà",

	"Na Bư",

	"Cường Lân",

	"Nguyễn Thị Hoài Thu",

	"Phạm Hồng Thành",

	"Hoài Thương Nguyễn",

	"Mẹ Ku Hân",

	"Phung Long",

	"Thuyhang Nguyen",

	"Nam Beng",

	"Ếch Đơ",

	"Nguyen Phan",

	"Điều Giản Dị",

	"Trịnh Vy",

	"Lộc Nguyễn Văn",

	"Linh Bui",

	"Thu Vu",

	"Bé Con Bố Châu",

	"Loc Lam Huy",

	"Cao Thị Hồng Cảnh",

	"Bánh Bao Đậu",

	"Sơn Trần",

	"Quynhanh Dinh",

	"Nga Nguyen",

	"Cẩm Trang",

	"Lan Nguyen",

	"Thanh Ngan Tran",

	"Minh Hai",

	"Nguyen Honghai",

	"Nhoc Xjnh",

	"Tri Dung Nguyen",

	"Lê Thị Mai Phương",

	"Bùi Tuấn Điệp",

	"Nguyễn Thạc Hoài",

	"Nguyen Thoa",

	"Mai Hoa",

	"Tắkkè Con",

	"Little Angle",

	"Huyền Trang",

	"Yen Thai",

	"Nguyen Nhung",

	"Nguyễn Viết Xuân",

	"Đặng Hưng Long",

	"Thu Tra",

	"Hien Lê",

	"Vu Tuan Dat",

	"Trần Hảo",

	"Giang",

	"Canh Do Khac",

	"Lê Na",

	"Mai Nguyễn",

	"Linh Dương",

	"Phú Nguyễn",

	"Kiều Đức Thắng",

	"Nhatdaovohinh Namct",

	"Lê Văn Khuyến",

	"Lương Việt Bắc",

	"Ngoc Ngo",

	"Nguyen Dieu Thanh",

	"Anh Ngoc Duong",

	"Đỗ Quốc Duy",

	"Huyen Vu",

	"Manh Hoang",

	"Hanh Hong",

	"Âu Văn Ỏn",

	"Hoàng Đinh",

	"Pj Sandy",

	"Nguyễn Trung Đức",

	"Anna Tran",

	"Trúc Quỳnh",

	"Nguyen Van Luong",

	"Nhung Lê",

	"Duy Minh Nguyễn",

	"Nguyễn Đức Hải",

	"Tiên Nguyễn",

	"Đinh Đông",

	"Foly O Simh",

	"Công Trần",

	"Ngô Đức",

	"Hoàng Bảo Bùi",

	"Dao Huyen Trang",

	"Hải Phùng",

	"Bi Chan Nguyễn",

	"Minh Đức",

	"Hoàng Vũ Trung",

	"Công Nguyễn Chí",

	"Mèo Mập Mạp",

	"Thu Lê",

	"Vo Van",

	"Loan Mai",

	"Lê Quyền",

	"Tô Đông Hoàng",

	"Sáng Xuân",

	"Chu Phương Dung",

	"Vinh Nguyen Duy",

	"Chu Nguyen",

	"Ký Ức Yêu Thương",

	"Minh Mạng",

	"Kiyan Tran Viet",

	"Hà Trang",

	"Phuong Anh Nguyen",

	"Thai Duong",

	"Ma Katz",

	"Thang Nguyen",

	"Nguyễn Hải Đăng",

	"Lâm Đoàn",

	"Ngốc Bẩm Sinh",

	"Đức Phạm Anh",

	"Mây Mong Manh",

	"Cóc Fung",

	"Tam Noong",

	"Gió Béo Ngậy",

	"Charming Panda",

	"Tỉnh Đoàn",

	"Phương Nguyen",

	"Lam Thuy",

	"Hữu Sevincon",

	"Quốc Lập",

	"Manh Phan",

	"Cong Nguyen",

	"Ajin Nô Mô Tô",

	"Chu' King",

	"Trang Be",

	"Hòa Còi",

	"Nguyễn Anh",

	"Ky Hoolee",

	"Huyền Đoàn",

	"Long Tom",

	"Anna Ruan",

	"Đậu Bích Hoài",

	"Thu Trang",

	"Trang Cao",

	"Oanh Vu",

	"Nguyen Ngoc Minh",

	"Binh Libra",

	"Hung Dat",

	"Majmjt Nguyen",

	"Hoang Chau",

	"Đỗ Tuấn Khải",

	"Zìn Zínn",

	"Hà Lê",

	"Duy Trung",

	"Nga Quỳnh",

	"Đinh Quang Vinh",

	"Vuong Nd",

	"Hoàng Giang",

	"Đinh Thị Bình",

	"Nguyễn Lan Hương",

	"Trung Sơn Lê",

	"Thu Tít",

	"Mây Mong Manh",

	"Tuấn Xác Ve",

	"Lê Cú",

	"Dong Jun",

	"Cucai Cuhanh",

	"Nguyễn Hải Yến",

	"Thành Lã",

	"Tony Việt",

	"Anh Tuan",

	"Thac Binh Cuong",

	"Đỗ Vinh",

	"Anh Tuấn",

	"An An Nguyen",

	"Bùi Đức Hiệu",

	"Xuân Vinh",

	"Đặng Ngọc Trâm",

	"Phan Hao",

	"Hoàng Hùng",

	"Ruan Shi Xian",

	"Yen Hoang",

	"Huong Nguyen",

	"Khiet Linh Ha",

	"Oanh Tặc",

	"Dung Nhi",

	"Phuonganh Nguyen",

	"Mai Ly",

	"Huy Meo Salem",

	"Hằng Nguyễn",

	"Lana Nguyễn",

	"Ngoc Bao Nguyen",

	"Đạo Hiệp Linh Kiện",

	"Thanh Hải",

	"Trần Văn Dũng",

	"Phong Hunter",

	"Ngô Thắng",

	"Từ Minh",

	"Hiep Duong",

	"Chất Độc",

	"Thu Hong Pham Thi",

	"Thuy Nguyen",

	"Minh NT",

	"Linh Nguyen",

	"Nguyen Hoa",

	"Hồ Thị Cam",

	"Việt Anh Nguyễn",

	"Satun Duong",

	"Hoàng Lê",

	"Bùi Tuyến",

	"Tô Ánh Nguyệt",

	"Đài Trang",

	"Duong Phuong",

	"Tam Mao",

	"Candy Lê",

	"Trong Nguyen",

	"Minh Thắng Hoàng",

	"Thiên Tim Hoàng",

	"Nguyễn Văn Giới",

	"Son Pham",

	"Thỏ Xig Xắn",

	"Hằng Nguyễn",

	"Neymar Phan",

	"Yêu Cu Tí",

	"Hoanglinhbk Nguyễn",

	"Ha Thanh Mai",

	"Nguyễn Thu Hằng",

	"Ha Nguyen",

	"Sách Nguyễn",

	"Hoang Link Hau",

	"Lương Thị Hoài Thu",

	"Hòa Nguyễn Văn",

	"Ngô Nướng",

	"Vinh Nguyen",

	"Chung Ccr",

	"Thang Le",

	"Hung Duong Van",

	"Dung Love",

	"Nguyen Thu Huong",

	"Dạ Vũ",

	"Gold Medal",

	"Biny Melody",

	"Phuong Minh",

	"Nguyễn Hữu Thọ",

	"Vũ Trung Quân",

	"Tân Nguyễn",

	"Thắng Đình Nguyễn",

	"Tùng Anh",

	"Quang Minh Nguyễn",

	"Hoàng Hoa",

	"Sala Jay Chou",

	"Thanh Nguyen",

	"Huy Hưng",

	"Nguyễn Lan Anh",

	"Thiên Linh",

	"Vũ Khắc Tín",

	"Hoàng Trang Starfish",

	"Đàm Khánh Phượng",

	"Gia Sư Catavet",

	"Tran Binh",

	"Khanhduy Nguyen",

	"Dương Thủy",

	"Cá Heo Xanh",

	"Khánh Tôn Thiện",

	"Ngoc GemMy",

	"Ngọc Hoa",

	"Hoàng Dung",

	"Hải Ngọt Ngào",

	"Yen Nguyenduc",

	"HoangKim HoàngLãogià",

	"Lmx Lmx",

	"Lê Đức Lâm",

	"Emi Phan",

	"Mũm Mĩm",

	"Hà Lê",

	"Diên Vĩ Litra",

	"Sunny Nguyen",

	"Ngôi Sao Nhỏ",

	"Diệu Thuần Nguyễn",

	"Lê Dương Thảo Nguyên",

	"Nobita Xuka",

	"Cần Một Khoảng Lặng",

	"Ánh Dương",

	"Nguyễn Mạnh Cường",

	"Võ Thanh Thủy",

	"Trang Le",

	"Sầu Thiên Thu",

	"Én Xing",

	"Hồng Ruby",

	"Le Ngoc Quyen",

	"Hà Nguyễn",

	"Vương Bảo Quang",

	"Ngày Và Đêm",

	"Linh Khánh",

	"Cứ Bình Yên",

	"Nu Pagadzi",

	"Mai Hữu Trần",

	"Tui Người Lớn",

	"Vịt Xấu Xí",

	"Phan Tố Nga",

	"Lê Văn Thiệp",

	"Văn Hải Nguyễn",

	"Anh Tuan Pham",

	"Steve Giáp",

	"Nguyễn Việt Hà",

	"Xinh Mập",

	"Huyen Vuong TaMi",

	"Lưu Anh Đức",

	"Khanh Ha",

	"Linh Hạnh Phúc",

	"Thuong Nguyen",

	"Hiếu Xù",

	"Công Quạ",

	"Lực Cristiano",

	"Anh Kiên",

	"Tran Minh",

	"Kem Vani",

	"Yenyen Jenny Yen",

	"Hoàng Lạc Quan",

	"Kiên Sóc Nâu",

	"Mạnh Cường Nguyễn",

	"Kimanh Pham",

	"Thùy Linh",

	"Toàn Nguyễn",

	"Kee Nguyen Dinh Huong",

	"Hanh Nguyen",

	"Huyền Anh Đỗ",

	"Mèo Hớn",

	"Giàng A Nhá",

	"Nguyễn Hữu Vụ",

	"Yen Nguyenduc",

	"Isee Trần",

	"Nguyễn Thượng Khang",

	"Lê Quốc Trung",

	"Kỹ Sư Tiến",

	"Thảo Nhi Nguyễn",

	"Vương Sơn Tùng",

	"Phan Hà Mi",

	"Mạnh Phạm",

	"Ngọc Thảo Vũ",

	"Thanh Nghiem",

	"Hoang Huy",

	"Vịt Vui Vẻ",

	"Este Chic",

	"Bimbim Xìtrum",

	"Quiny Nguyen",

	"Dinh Thangkk",

	"Đào Thị Thu Trang",

	"Đại Ca Đức",

	"Kim Ngân Lmx",

	"Thao Linh",

	"Tít Tìn Tịt",

	"Angelina Nguyễn",

	"Tân Hoàng",

	"Linh Chi Nguyen",

	"Ken Kun",

	"Cáo Ngây Thơ",

	"Lam Lương",

	"Hung Xlkd",

	"Ny Nguyen",

	"Trang Loli",

	"Phung Thi Thuy Nga",

	"Neon Candy",

	"Tiểu Yêu",

	"Phạm Văn Hưng",

	"Trangoliver Huyền",

	"SusuloLi LinhLinh",

	"Huong Ha",

	"Thảo An",

	"Nguyễn Ngọc Thuỷ",

	"Hanh Dang Vu",

	"Nga Coi Pro",

	"Tùng Lì",

	"Dương Hiệp",

	"Hương Giang Jo",

	"Vợ Chú Để Anh",

	"Thùy Linh Nguyễn",

	"Thanh Nhan Phan",

	"Tú Anh",

	"Thảo Bông",

	"Tiểu Mục Đồng",

	"Lan Quynh",

	"Teamin Trang",

	"Việt Dũng",

	"Bùi Hà Thu Hiền",

	"William Bui Truong",

	"Tuấn Anh",

	"Khoảng Lặng",

	"Linh Chi",

	"LiNa Linh",

	"Coy Iu",

	"Tùng Ngô Xuân",

	"BI Bin",

	"Tram Nguyen",

	"Nguyễn Thu Huyền",

	"Cong Ngo",

	"Minh Phuong",

	"Lan Thuan",

	"Le Ho",

	"Lightning's Son",

	"Satthu PhongVan",

	"Lộ Bàn Thổ",

	"Mimoza Yến",

	"Kien Truong",

	"Kent Keo Kiệt",

	"Hoàng Lê",

	"Michael Haf",

	"Bib Nguyễn",

	"Lê Trần Ngọc Bích",

	"Đô Đô Nguyen",

	"Cách Cách Họ Nguyễn",

	"We're So Cool",

	"An Hà",

	"Tâm Đặng",

	"Suha Nguyễn",

	"Avrilla Nguyen",

	"Vinh Lê",

	"Bông Tsunami",

	"Cuong Hong",

	"Ngày Xưa Ơi",

	"Lala RuBy",

	"Đức Phạm Đình",

	"Lu Na",

	"Minh Hiệp",

	"Chiến Bờm",

	"Huyen Thuong",

	"Khăc Tu",

	"Bui Nhu Quynh",

	"Yáng Shi Hóng",

	"Meo Beo",

	"Huy Lapro",

	"Kiên Cò",

	"Hoàng Vân",

	"Luc Linh Lam",

	"Thái Hòa Trương",

	"Huy Cong",

	"Nguyễn Đức Dũng",

	"Phoenix Mx",

	"Ngân Lê Thuỷ",

	"Hạnh Phạm",

	"Doan Phat",

	"Chi Chi Chành Chành",

	"Yêu Mãi",

	"Frozen Ha",

	"Thùy Dương Nguyễn",

	"Tôn Nguyên Nguyên",

	"Bunny Vũ",

	"Kook Kik",

	"Ngô Đình Công",

	"Mai Tùng Quân",

	"Ngọc Trâm",

	"Up Love",

	"Nho Yoomi",

	"Thu Tho Ngoc",

	"Ha Ngo Thu",

	"Na Mi",

	"Bánh Bao Trứng",

	"Hoanglan Hoanglan",

	"Hana Kim Nguyen",

	"Phạm Đình Sỹ",

	"Ngoc Anh Nguyen",

	"Tuan Dung",

	"Quỳnh Nga",

	"Hong Phong Pham",

	"An Fi Do",

	"Tuan Anh Tran",

	"Nhung Hana",

	"Mạnh Thắng Nguyễn",

	"Chuột Nhắt",

	"Nguyễn Huy",

	"Trinh Tham",

	"Anhtuan Nguyen",

	"Quang Tiến Nguyễn",

	"Minh ND",

	"Dương Vĩ",

	"Lê Loan",

	"Đinh Quang Huy",

	"Nga Trần",

	"Ly Cao",

	"Huy LC",

	"Hương Bùi",

	"Lê Văn Toán",

	"Để Xem",

	"Xuandai Dang",

	"Lưu Dũng",

	"Răng Sâu",

	"Dolphin Huyen",

	"Vân Cloud",

	"Nguyễn Hà Phương",

	"Bas Six",

	"Lê Như Ngọc",

	"Ducon FK",

	"Long Nguyễn",

	"Quý Nguyễn",

	"Sương Suri",

	"Linh Julia",

	"Quynh Diep Nguyen",

	"Miu Ngoan Hiền",

	"Người Đàn Ông",

	"Kem Ly",

	"Lưu Tây Mỹ Tử",

	"Nấm Leng Keng",

	"Nhung Nguyen",

	"Trần Đăng Hóa",

	"Nam Nguyen Quoc",

	"Bùi Chung",

	"Thanh Hai Nguyen",

	"Tra Le",

	"Diện Thạch",

	"Link Cá Sấu",

	"Mai Quỳnh",

	"Hường Tipfunly",

	"Quang Be",

	"Nhung Nguyen",

	"Vananh Hoang",

	"Teo Beo",

	"Vương Anh",

	"Hoai Yumi",

	"Doãn Việt",

	"Bin Le",

	"Minh Hằng",

	"Thủy Tiênn",

	"Hưởng Nguyễn",

	"Linh Ngây Thơ",

	"Chiến Hoàng Nghĩa",

	"Bui Quang Dat",

	"Nguyễn Đức Thành",

	"John Smith",

	"Anh Chang Ngok",

	"Sên Mập",

	"Wangtieepj Lee",

	"Trọng Hoàn",

	"Là Băng",

	"Tran Thuy Huyen",

	"Huyền Lê",

	"July Mju Tran",

	"Nina Thủy",

	"Nguyễn Quốc Huy",

	"Xu Xu",

	"Jewel Orchid",

	"Đinh Luận",

	"Nam Văn",

	"Trang Minh",

	"Tuấn Trúc Hậu",

	"BkPro File",

	"Vân Anh Nguyễn",

	"Thu Thao Nguyen",

	"Phan Nhung",

	"Phương Zenzii",

	"Nancy Vi Nguyen",

	"Cô Đơn",

	"Hải Trần Đức",

	"Trọng Huấn",

	"Văn Lực",

	"Lan Xuka",

	"Quynh Huong CrazyOnes",

	"Kim Tuyến",

	"Thế Anh Trần",

	"Hòa Nguyễn",

	"Hiếu Mầy",

	"Hùng Đoàn",

	"Trịnh Xuân Thuận",

	"Hoang Dung",

	"Cham Amy",

	"Phong Đào",

	"Nga Quynh",

	"Anh Dang Hoang",

	"Nguyễn Yến Lazy",

	"Hằng Katy",

	"TQ Dũng",

	"Anna Dung",

	"Tôn Nữ Thiện Trang",

	"Tạ Văn Đôn",

	"Nguyen Duc Dong",

	"Ba Béo",

	"Bi Bé Bỏng",

	"Trung Kiên",

	"Vy Hồ",

	"Vigoss Nighter",

	"Thảo Ta",

	"Thao Le",

	"Võ Thành Đồng",

	"Vân",

	"Anh Quân",

	"Quỳnh Víc",

	"NeuCon NgayMai",

	"Bố Bạn",

	"Tuấn Vũ",

	"Phạm Việt Hà",

	"Mon Chibi",

	"Đăng Bụi",

	"Chocopie Là Orion",

	"Dinh Xuan Ngoc",

	"Thùy Nguyễn",

	"Tuấn Ngọc Phạm",

	"Trà Nguyễn",

	"Nguyễn Đại Dương",

	"Mai IU IU",

	"La Coste",

	"Kakashi King",

	"Pook Pik",

	"Phạm Trang",

	"Thảo Aries",

	"Hao Seven",

	"Thủy Tiên",

	"Linh Tran",

	"Thanh Van",

	"Tùng Phèng",

	"Văn Lâm Dương",

	"Long Lê",

	"Lê Meo",

	"Bích Phương",

	"Quỳnh Bella",

	"Hiếu Kỳ",

	"Hoa Hoai Thu",

	"Manh Dung Mobjle",

	"Nhỏ Bim",

	"Pon Tậptànhtrởthành TrởThành TổngThống",

	"Mây Bùi",

	"Claire Can Đảm",

	"Bee Phuong Tran",

	"Minh Thúy",

	"Linh Nguyen",

	"Ninh Ngoc",

	"Luong Vinh",

	"Anh Tuan",

	"Dung Lùn",

	"Tú Tý Tởn",

	"Hương Vũ",

	"Hanh Phung",

	"Rắn Đầu To",

	"Khoai Tây",

	"Nguyễn My",

	"Trongdai Tran",

	"Cào Cào Lá Tre",

	"Kem Béo",

	"Bé Đậu",

	"Nguyễn Thành Trung",

	"Đồng Apple",

	"Ngọc Hiếu",

	"Huong Do",

	"Chuột Moschino",

	"Bùi Nữ Thục Anh",

	"Trần Thế Nhật",

	"Linh Bui",

	"Bất Cần Đời",

	"Sếu Đầu Đỏ",

	"Sơn Nobi",

	"Bắp Trà",

	"Thảo Chu",

	"Táo An Ninh",

	"Dung Dí Dỏm",

	"Trang Vo",

	"Trang Tồ",

	"Nam Vu",

	"Nguyen Ba Dung",

	"Lee Cloud",

	"Đào Trung",

	"Lưu Tây Mỹ Tử",

	"Hói Hững Hờ",

	"Bé Trang",

	"Diệp Vân",

	"Nguyen Quoc Hoang",

	"Siêu Nhân",

	"Băng Sương Nguyễn Thị",

	"Minh Hằng",

	"Phạm Hà Giang",

	"Dich Dinh",

	"Hung Lan",

	"Sa Là Lá La",

	"Bun",

	"Khánh Thương",

	"Mây SoCiu",

	"Mạnh ShaKer",

	"Thùy Lê",

	"Mạnh Nguyễn Quang",

	"Khoảng Lặng",

	"Quỳnh Roi",

	"Shiro Kun",

	"Quang Trung",

	"Cbiz Liba",

	"Phuong Nguyen",

	"Duc Cuong",

	"MêMan Trong MànĐêm",

	"Tran Minh Duc",

	"Quynh Xu",

	"Dang Tuan",

	"Vân Anh Phạm",

	"Joan BrownEyes",

	"Van Le",

	"Trang Nguyễn",

	"Tắc Kè Hoa",

	"Anh Lan Nguyễn",

	"Hip Na",

	"Thu Đỗ",

	"Thuong Yeu Yeu Thuong",

	"Black Roses",

	"Hong Vu",

	"Thủy Trinh Nguyễn",

	"Anh Thuy",

	"Yến Bống",

	"Thùy Linh",

	"Hoa Tươi Tắn",

	"Su Ri",

	"Nguyễn Ngọc Huyền",

	"Loan Lém Lỉnh",

	"Nhung Còi",

	"Lam Nguyễn",

	"Lê Trà",

	"Tran Thi Khanh Ly",

	"Kún Xink",

	"Trà Sữa Đắng",

	"Vit Pham",

	"Huong Doti",

	"Trang Kẹo",

	"Nguyễn Phương My",

	"Công Thành",

	"Hien Nguyen",

	"Đức Thắng Nguyễn",

	"Moon LuckyMoon",

	"Hana Han",

	"Vân Phan",

	"Huệ Lê",

	"Bông Tuyết Nhỏ",

	"Đô Đô",

	"Cánh Chim Trời",

	"Chù Misu",

	"Khánh Linh",

	"Trong An",

	"Văn Tường Oanh",

	"Thảo Gà",

	"Tiểu Gia",

	"Nhỏ Cherry",

	"Đình Anh Trần",

	"Cao Đàn",

	"Chin Ho",

	"Thơ Trần",

	"Hai Phung Van",

	"Ha Ngo",

	"Đỗ Cường",

	"Sim Simi",

	"Mít Còi",

	"Thúy An",

	"Phạm Thu Hà",

	"LyTu Ty",

	"BýBý NaNa",

	"Trung Huy Nguyễn",

	"Bùi Như Lạc",

	"Hoe Kute",

	"Moon Blade",

	"Văn Tuấn Lương",

	"Bi Xu",

	"Thuận Phan",

	"Em Hiểu Mìnhchiatay",

	"Thaole Le",

	"Le Hoai Chung",

	"Kem Vani",

	"An Thúy",

	"Le Huan",

	"Savjor Lee",

	"Bèm Bụ Bẫm",

	"Trang Đài",

	"Phuong Thu Tran",

	"Đặng Đồng",

	"Gió Lạnh",

	"Củ Tỏi Lai",

	"Hải Hà",

	"Mèo Béo",

	"Thoa Ngoc",

	"Ớt Ngọt",

	"Hồng Yến Nguyễn",

	"Phan Linh",

	"Tài Vũ",

	"Lê Hằng",

	"Mắt Cười",

	"Mai Phan",

	"Em Chanh",

	"Coffee Black",

	"Ngot Ngao",

	"Bùi Trà My",

	"Bé Ngố",

	"Buti Ki",

	"Hoai An",

	"Nguyễn Thế Tâm",

	"Hùng Dương",

	"Sôcôla Sữa",

	"Sammy Chi",

	"David Trung",

	"Phú Nam Quách",

	"Boo Bi",

	"Xinh Nhat Nha",

	"Nguyễn Trọng Thơm",

	"Cỏ Dại",

	"Cường Kun",

	"Hà Phan",

	"Minh Trần",

	"Kun Iu",

	"Vu Vơ",

	"Trang Le",

	"Ngân Phan",

	"Uyn Ni Pu",

	"Hà Trang",

	"Heo Cao",

	"Ngoc Van Phan Thi",

	"Bạch Dương Ftu",

	"Văn Nguyễn Quốc",

	"Thảo Nguyên Xanh",

	"Dory Kiki",

	"Quả Táo Vàng",

	"Conanchocolate Tran",

	"Hoang Danh",

	"Bi Cu Te",

	"Mai Lê",

	"Bicute Trang",

	"Hưng Chuột",

	"Trung Đặng Khánh",

	"Brian Samuel",

	"Văn Tú Lê",

	"Hương A Đầu",

	"Trần Phương",

	"Chung Hin",

	"Linh Lê",

	"Yuuki Nioko",

	"Linh Trần",

	"Thực Hành Kế Toán",

	"Linh Kem Lmx",

	"Ngốc Nghếck",

	"Trần Mạnh Hùng",

	"All Fall Down",

	"Hà Min",

	"Trường Duy Dương",

	"Lackylac Hai",

	"Hoa Davichi",

	"Hanna Bi",

	"Kem Kute",

	"Giang Phùng",

	"Nu No",

	"Dung Phan",

	"Khánh Huyền",

	"Phong Wind",

	"Ngọc Ruby",

	"Phương Anh",

	"Giang Pham",

	"Cá Chép Vàng",

	"Mạnh Lê",

	"Thảo Huyền Nguyễn",

	"Hương Thảo Nguyễn",

	"Vân Nany",

	"Bo Cong Anh",

	"Tiến Thương",

	"Rơm Rơm",

	"Lê Mai",

	"Thu Vit",

	"Phạm Ngọc Sơn",

	"Lặng Thầm",

	"Ngan Cutee",

	"Nguyễn Kim Thành",

	"Lam Nguyen",

	"Vi Vu",

	"Lac Trung",

	"Bảo Thoa",

	"Hoàng Hà",

	"Trung Ngo Van",

	"Nguyễn Thị Thuý",

	"An Na Nguyễn",

	"Jeny Lì Lượm",

	"Ngủ Quên",

	"Phạm Tuấn",

	"Ngọc Nguyễn",

	"Tra Phan",

	"Shimmering Love U",

	"Trang Phạm Kiều",

	"Ngọc Huê",

	"Ngô Ngân",

	"NgheAn Choa",

	"Thoa Nguyen",

	"Mai Anh Sang",

	"Boy Golden",

	"Huyền Suri",

	"Ngọc Ka",

	"Moon Love",

	"Hoàng Trương",

	"Huynh Quyet Thang",

	"Hoa Võ",

	"Thảo Dím",

	"Le Trang",

	"Hoàng Thị Thảo",

	"Kim Ngân Lmx",

	"Chuông Gió",

	"Nelly Figueroa",

	"Ngọc Mai",

	"Thanh Tâm Phạm",

	"Bu Còi",

	"Kelvin Lee",

	"Yên Đinh Tiên",

	"Hùng Đặng",

	"Nguyen Thanh Thuy",

	"Cỏ Dại",

	"Hiep Ngo Xuan",

	"Lee Hoàn Singer",

	"Cậu Chủ Nhỏ",

	"Trần Thị Ngân",

	"Nguyên Ngọc Anh",

	"Cao Phi Hoàng",

	"Thanh Thu",

	"Phú Trầnn",

	"Khong Tru Ai Ca",

	"Uyen BK",

	"RoyRon CK",

	"Đồng Dân BA Bảy",

	"Kiếp Lang Thang",

	"Bùi Anh Hùng",

	"Soleio Hy",

	"Giáo Dục Giới Tính",

	"Net Game Thong Ngoc",

	"Ha Trang",

	"Tuan Le",

	"Trang Chipshop",

	"Hoàng Tử Lạnh Lùng",

	"Bẹp Chi",

	"Leader Kwon",

	"Kitty Nguyen",

	"Linh Barbie",

	"Simibon Măm Măm",

	"Lú Íts Mê",

	"Dương Nguyễn",

	"Jmmy Ha",

	"Ngân Anh",

	"Duc Tran Viet",

	"Hường Mèo",

	"Choi Yong Min",

	"Văn Thế Nguyễn",

	"Ku Kin",

	"Hà Dũng",

	"Phạm Linh",

	"Kubin NA BD",

	"Lương Nguyễn",

	"Hoa Bồ Công Anh",

	"Oanh Phan",

	"Nổ Đoàng Đoàng",

	"Trần Thanh Trà",

	"Bé Siu Nhân",

	"Bùi Phương Thảo",

	"Thỏ Ngọc",

	"NhuNgoc Be",

	"Ha Tran",

	"KimHue FC Bat",

	"Đấu Chiến Thắng Phật",

	"Nguyen Tjen Anh",

	"Thành Kọt",

	"Em Muốn Dừng Lại",

	"Vương Duy Na",

	"Handanog Kiep Nay",

	"Ngọc Chói Lóa",

	"Ha Vuong",

	"Trang Angel",

	"Ngáo Ộp",

	"Mùa Hạ Mưa",

	"Út Chảnh",

	"Nhím",

	"Nguyễn Huyền",

	"Tiến Tỉnh",

	"Manh Ngo Viet",

	"Thinh Pham",

	"Nhok Ánh",

	"Khoa Vu",

	"Chuột SeVen",

	"Hà Vy Hoàng",

	"Lyk Bin",

	"Ngọa Long Bắc Hà",

	"Be Buon",

	"Thắng Trần Đình",

	"Quân Bim",

	"SiêuNhân Đỏ",

	"Gia Huy",

	"Lee Dekel",

	"Yến Su",

	"Sơn Nguyễn Bá",

	"Ngọt Hồ",

	"Hòa Phan",

	"Dũng Đứng Đắn",

	"Ori Mio",

	"Kẻ Dấu Mặt",

	"Hưng Jerry",

	"Anh Phạm",

	"Mai Thuy",

	"Xuân Ngô",

	"Minh Thủy Minh",

	"Candy Nguyen",

	"Hà Dũng",

	"Minh Tiến",

	"Nguyễn Thu Hương",

	"Hiep Dang Vu",

	"Thu Trang Đào",

	"Trang Tốt Tính",

	"Bóng Tối",

	"Pham Toan",

	"CàChua Yêu CàPháo",

	"Nhung Ianta",

	"Fly Sky",

	"Bao Ngoc Le",

	"Lùn Kệ Tao",

	"Thích Khách",

	"Nguyên Bùi",

	"Mật Ong Rừng",

	"Thường Lệck",

	"Tín Nhút Nhát",

	"Thúy Hồ",

	"Bùi Văn Thành",

	"Xương Rồng Gai",

	"Lam Smile Smile",

	"Loan Đặng",

	"Su Per Zồ",

	"Thùy Nguyễn Thị Minh",

	"Tồ Virgo",

	"Hùng Trần",

	"Tran Duc",

	"Hong Nhung Trantran",

	"Con Người",

	"Nguyễn Tuấn Đạt",

	"Thanh Thu",

	"Thu Hến",

	"Quyên",

	"Hà Nguyễn",

	"Ma Ma Tổng Quản",

	"Hoai Nam Nguyen",

	"Kute Đỗ Phương",

	"Thiep Ha",

	"Susu LoLi",

	"Sâu Béo",

	"Hữu Thành Lã",

	"Ha Nguyen"

	};
	
	private static String[] listFacemousPlace = {
		"ho-xuan-huong-da-lat-lam-dong-tourist-resource",
		"thac-prenn-da-lat-lam-dong-tourist-resource",
		"thung-lung-tinh-yeu-dep-tua-nhu-mot-buc-tranh-thuy-mac-da-lat-lam-dong-tourist-resource",
		"di-tich-dinh-bao-dai-dinh-iii-trieu-viet-vuong-da-lat-lam-dong-tourist-resource",
		"thien-vien-truc-lam-da-lat-lam-dong-tourist-resource",
		"tuyen-lam-da-lat-lam-dong-tourist-resource",
		"thac-lieng-rowoa-thac-voi-nam-ban-lam-ha-lam-dong-tourist-resource",
		"sinh-thai-ba-ho-ninh-hoa-khanh-hoa-tourist-resource",
		"phu-cang-van-ninh-khanh-hoa-temple",
		"dam-mon-xa-van-thanh-van-ninh-khanh-hoa-peninsula",
		"duc-ba-church",
		"hon-ong-van-ninh-khanh-hoa-tourist-resource",
		"lang-det-chieu-my-trach-ninh-hoa-khanh-hoa-tourist-village",
		"lang-nghe-tac-tuong-bao-ha-xa-dong-minh-vinh-bao-hai-phong-tourist-village",
		"khu-di-tich-alexandre-yersin-xa-suoi-cat-dien-khanh-khanh-hoa-tourist-resource",
		"buu-long-dien-khanh-xa-dien-tho-dien-khanh-khanh-hoa-pagoda",
		"ba-dinh-square",
		"thien-hau-temple",
		"cat-co-cat-hai-hai-phong-beach",
		"tran-quoc-pagoda",
		"xuan-Ðung-van-ninh-khanh-hoa-beach",
		"giac-hai-xa-van-hung-van-ninh-khanh-hoa-pagoda",
		"khu-di-tich-trang-trinh-nguyen-binh-khiem-xa-ly-hoc-vinh-bao-hai-phong-tourist-resource",
		"ben-thanh-market",
		"hanoi-opera-house",
		"lang-nghe-duc-dong-tram-tuoi-o-khanh-hoa-dien-khanh-khanh-hoa-tourist-village",
		"hon-khoi-ninh-hoa-khanh-hoa-peninsula",
		"du-hang-121-du-hang-le-chan-hai-phong-pagoda",
		"am-chua-xa-dien-dien-dien-khanh-khanh-hoa-tourist-resource",
		"sat-hong-bang-hai-phong-market",
		"bao-phong-ninh-hoa-khanh-hoa-pagoda",
		"lang-ba-vu-phuong-ninh-hiep-ninh-hoa-khanh-hoa-tourist-resource",
		"sinh-thai-the-thao-waterland-suoi-thach-lam-xa-suoi-cat-cam-lam-khanh-hoa-tourist-resource",
		"van-mieu-dien-khanh-thi-tran-dien-khanh-dien-khanh-khanh-hoa-temple",
		"thien-loc-xa-dien-khanh-dien-khanh-khanh-hoa-pagoda",
		"ngoc-van-van-ninh-khanh-hoa-tourist-resource",
		"bao-long-xa-ninh-quang-ninh-hoa-khanh-hoa-pagoda",
		"thien-buu-xa-ninh-phung-ninh-hoa-khanh-hoa-pagoda",
		"vinh-cam-ranh-cam-ranh-khanh-hoa-tourist-resource",
		"municipal-theatre",
		"thien-phuoc-xa-van-hung-ninh-hoa-khanh-hoa-pagoda",
		"hang-kenh-le-chan-hai-phong-temple",
		"bien-dai-lanh-van-ninh-khanh-hoa-tourist-resource",
		"ba-na-nui-chua-hoa-vang-da-nang-tourism-complex",
		"one-pillar-pagoda",
		"turtle-tower",
		"ho-chi-minh-mausoleum",
		"my-khe-son-tra-da-nang-beach",
		"ngoc-cat-ba-cat-ba-cat-hai-hai-phong-island",
		"tu-van-phuong-cam-linh-cam-ranh-khanh-hoa-pagoda",
		"vinh-ninh-van-ninh-hoa-khanh-hoa-tourist-resource",
		"tho-tran-quy-cap-thi-tran-dien-khanh-dien-khanh-khanh-hoa-temple",
		"dinh-doc-lap",
		"suoi-tien-dien-khanh-khanh-hoa-tourist-resource",
		"ngu-hanh-son-ngu-hanh-son-da-nang-mountain",
		"suoi-thach-lam-xa-suoi-cat-cam-lam-khanh-hoa-tourist-resource",
		"hoang-thanh-thang-long",
		"son-tra-son-tra-da-nang-peninsula",
		"dan-da-khanh-son-khanh-son-khanh-hoa-tourist-resource",
		"west-lake",
		"phat-quang-xa-ninh-hai-ninh-hoa-khanh-hoa-pagoda",
		"sac-tu-thien-tu-ninh-hoa-khanh-hoa-pagoda",
		"sinh-thai-dam-nha-phu-hon-lao-hon-thi-ninh-hoa-khanh-hoa-tourist-resource",
		"hanoi-big-church",
		"hoan-Kiem-lake",
		"linh-ung-ngu-hanh-son-da-nang-pagoda",
		"vinh-van-phong-van-ninh-khanh-hoa-tourist-resource",
		"linh-son-xa-van-luong-van-ninh-khanh-hoa-pagoda",
		"vietnam-fine-art-museum",
		"du-lich-yang-bay-xa-khanh-phu-khanh-vinh-khanh-hoa-park"
	};
}
